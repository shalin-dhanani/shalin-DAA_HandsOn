import java.util.*;

public class GraphDFS {
    private Map<Character, List<Character>> adjacencyList;

    public GraphDFS() {
        adjacencyList = new HashMap<>();
    }

    
    public void addEdge(char source, char destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source); // For undirected graph
    }

    
    public void depthFirstSearch(char startNode) {
        Set<Character> visited = new HashSet<>();
        dfsRecursive(startNode, visited);
    }

    // Helper method for recursive DFS
    private void dfsRecursive(char node, Set<Character> visited) {
        if (visited.contains(node)) return;

        System.out.print(node + " ");
        visited.add(node);

        for (char neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
            dfsRecursive(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS();

        
        graph.addEdge('a', 'b');
        graph.addEdge('a', 'h');
        graph.addEdge('b', 'c');
        graph.addEdge('b', 'h');
        graph.addEdge('c', 'd');
        graph.addEdge('c', 'i');
        graph.addEdge('c', 'f');
        graph.addEdge('d', 'e');
        graph.addEdge('d', 'f');
        graph.addEdge('e', 'f');
        graph.addEdge('f', 'g');
        graph.addEdge('g', 'h');
        graph.addEdge('g', 'i');
        graph.addEdge('h', 'i');

        System.out.println("Depth First Search starting from node 'a':");
        graph.depthFirstSearch('a');
    }
}
