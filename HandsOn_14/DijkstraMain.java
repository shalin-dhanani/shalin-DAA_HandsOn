import java.util.*;

public class DijkstraMain {

    static class Edge {
        int target, weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);

            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int target, int weight) {
            adjacencyList.get(source).add(new Edge(target, weight));
        }

        public void dijkstra(int startVertex) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            pq.offer(new int[]{startVertex, 0});

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentVertex = current[0];
                int currentDistance = current[1];

                if (currentDistance > distances[currentVertex]) continue;

                for (Edge edge : adjacencyList.get(currentVertex)) {
                    int neighbor = edge.target;
                    int newDist = currentDistance + edge.weight;

                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        pq.offer(new int[]{neighbor, newDist});
                    }
                }
            }

            System.out.println("Shortest distances from source vertex " + startVertex + ":");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Vertex " + i + ": " + distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5); 
      
        graph.addEdge(0, 1, 10); // s -> t
        graph.addEdge(0, 2, 5);  // s -> y
        graph.addEdge(1, 2, 2);  // t -> y
        graph.addEdge(1, 3, 1);  // t -> x
        graph.addEdge(2, 1, 3);  // y -> t
        graph.addEdge(2, 3, 9);  // y -> x
        graph.addEdge(2, 4, 2);  // y -> z
        graph.addEdge(3, 4, 6);  // x -> z
        graph.addEdge(4, 0, 7);  // z -> s
        graph.addEdge(4, 3, 4);  // z -> x

        graph.dijkstra(0); // Starting from source vertex 0
    }
}
