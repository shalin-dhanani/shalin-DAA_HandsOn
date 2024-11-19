import java.util.*;

public class TopologicalSortExample {
    private int vertices;
    private List<Integer>[] adjList;

    public TopologicalSortExample(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void topologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        System.out.println("Topological Sort Order:");
        while (!stack.isEmpty()) {
            System.out.print((char) (stack.pop() + 'm') + " ");
        }
    }

    private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        
        TopologicalSortExample graph = new TopologicalSortExample(12); // 12 nodes (m to z)
        graph.addEdge(0, 4);  
        graph.addEdge(0, 5);  
        graph.addEdge(0, 9);  
        graph.addEdge(1, 4);  
        graph.addEdge(1, 6);  
        graph.addEdge(1, 2);  
        graph.addEdge(2, 5);  
        graph.addEdge(2, 7);  
        graph.addEdge(2, 10); 
        graph.addEdge(3, 2);  
        graph.addEdge(3, 7);  
        graph.addEdge(3, 11); 
        graph.addEdge(4, 8);  
        graph.addEdge(5, 6);  
        graph.addEdge(5, 10); 
        graph.addEdge(7, 5);  
        graph.addEdge(8, 9);  
        graph.addEdge(8, 10); 
        graph.addEdge(6, 10); 
        graph.addEdge(10, 11); 
        graph.addEdge(9, 11);  

        graph.topologicalSort();
    }
}
