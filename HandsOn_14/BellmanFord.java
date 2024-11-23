import java.util.Arrays;

class BellmanFord {

    
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Bellman-Ford Algorithm
    public static void bellmanFord(int vertices, int edgesCount, Edge[] edges, int source) {
        
        int[] distance = new int[vertices];
        int[] predecessor = new int[vertices]; 
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        distance[source] = 0;

        
        for (int i = 1; i < vertices; i++) {
            for (int j = 0; j < edgesCount; j++) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    predecessor[v] = u; // Update the path
                }
            }
        }

        
        for (int j = 0; j < edgesCount; j++) {
            int u = edges[j].source;
            int v = edges[j].destination;
            int weight = edges[j].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        
        printSolution(distance, predecessor, source);
    }

    
    public static void printSolution(int[] distance, int[] predecessor, int source) {
        System.out.println("Vertex Distance from Source and Path:");
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + ": No path from source");
            } else {
                System.out.print("Vertex " + i + " : " + distance[i] + " (Path: ");
                printPath(i, predecessor);
                System.out.println(")");
            }
        }
    }

    
    public static void printPath(int current, int[] predecessor) {
        if (current == -1) {
            return;
        }
        printPath(predecessor[current], predecessor);
        System.out.print(current + " ");
    }

    
    public static void main(String[] args) {
        int vertices = 5; 
        int edgesCount = 10; 

        Edge[] edges = new Edge[edgesCount];

    
        edges[0] = new Edge(0, 1, 6);
        edges[1] = new Edge(0, 2, 7);
        edges[2] = new Edge(1, 3, 5);
        edges[3] = new Edge(1, 2, 8);
        edges[4] = new Edge(1, 4, -4);
        edges[5] = new Edge(2, 3, -3);
        edges[6] = new Edge(2, 4, 9);
        edges[7] = new Edge(3, 1, -2);
        edges[8] = new Edge(4, 0, 2);
        edges[9] = new Edge(4, 3, 7);

        
        bellmanFord(vertices, edgesCount, edges, 0);
    }
}
