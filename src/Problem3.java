import java.util.Scanner;

public class Problem3 {
    private final int vertices;
    private final boolean[][] adjacencyMatrix;

    public Problem3(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new boolean[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = adjacencyMatrix[destination][source] = true;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && hasCycleUtil(i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int current, boolean[] visited, int parent) {
        visited[current] = true;
        for (int neighbor = 0; neighbor < vertices; neighbor++) {
            if (adjacencyMatrix[current][neighbor]) {
                if (!visited[neighbor] && hasCycleUtil(neighbor, visited, current)) {
                    return true;
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Problem3 graph = new Problem3(vertices);

        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (scanner.nextInt() == 1) {
                    graph.addEdge(i, j);
                }
            }
        }

        System.out.println(graph.hasCycle() ? "Graph contains a cycle." : "Graph does not contain a cycle.");

        scanner.close();
    }
}
