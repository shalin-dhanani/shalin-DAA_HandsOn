import java.util.*;

class Edge implements Comparable<Edge> {
    char source, destination;
    int weight;

    public Edge(char source, char destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class KruskalAlgorithm {
    private List<Edge> edges; // List of all edges
    private Map<Character, Character> parent; // Disjoint Set parent map
    private Map<Character, Integer> rank; // Rank map for DSU

    public KruskalAlgorithm() {
        edges = new ArrayList<>();
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    public void addEdge(char source, char destination, int weight) {
        edges.add(new Edge(source, destination, weight));
        parent.putIfAbsent(source, source); 
        parent.putIfAbsent(destination, destination);
        rank.putIfAbsent(source, 0);
        rank.putIfAbsent(destination, 0);
    }

    private char findParent(char node) {
        if (parent.get(node) != node) {
            parent.put(node, findParent(parent.get(node)));
        }
        return parent.get(node);
    }

   
    private void union(char node1, char node2) {
        char parent1 = findParent(node1);
        char parent2 = findParent(node2);

        if (parent1 != parent2) {
            if (rank.get(parent1) > rank.get(parent2)) {
                parent.put(parent2, parent1);
            } else if (rank.get(parent1) < rank.get(parent2)) {
                parent.put(parent1, parent2);
            } else {
                parent.put(parent2, parent1);
                rank.put(parent1, rank.get(parent1) + 1);
            }
        }
    }

    // Kruskal's algorithm to find MST
    public void kruskalMST() {
        // Sort edges by weight
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>(); // Store MST edges
        int totalWeight = 0;

        for (Edge edge : edges) {
            // Check if adding this edge creates a cycle
            if (findParent(edge.source) != findParent(edge.destination)) {
                mst.add(edge);
                totalWeight += edge.weight;
                union(edge.source, edge.destination);
            }
        }

        // Print the MST
        System.out.println("Edges in the Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm();

        
        graph.addEdge('a', 'b', 4);
        graph.addEdge('a', 'h', 8);
        graph.addEdge('b', 'h', 11);
        graph.addEdge('b', 'c', 8);
        graph.addEdge('c', 'i', 2);
        graph.addEdge('c', 'f', 4);
        graph.addEdge('c', 'd', 7);
        graph.addEdge('d', 'e', 9);
        graph.addEdge('d', 'f', 14);
        graph.addEdge('e', 'f', 10);
        graph.addEdge('f', 'g', 2);
        graph.addEdge('g', 'h', 1);
        graph.addEdge('g', 'i', 6);
        graph.addEdge('h', 'i', 7);

       
        graph.kruskalMST();
    }
}

