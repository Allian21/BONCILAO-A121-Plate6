//Problem 3

import java.util.Scanner;

public class Problem3 {
    private final int vertices;
    private final boolean[][] adjacencyMatrix;


    public Problem3(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new boolean[vertices][vertices];
    }

    // Method to add an edge
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = true;
        adjacencyMatrix[destination][source] = true; // Since the graph is undirected
    }

    // Method to check if the graph contains a cycle
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Utility method for DFS
    private boolean hasCycleUtil(int current, boolean[] visited, int parent) {
        visited[current] = true;
        for (int neighbor = 0; neighbor < vertices; neighbor++) {
            if (adjacencyMatrix[current][neighbor]) {
                if (!visited[neighbor]) {
                    if (hasCycleUtil(neighbor, visited, current)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of vertices
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Problem3 graph = new Problem3(vertices);

        // Read adjacency matrix
        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph.adjacencyMatrix[i][j] = scanner.nextInt() == 1;
            }
        }

        // Read the source node
        System.out.print("Enter source for Graph: ");
        int source = scanner.nextInt();

        // Check if the graph has a cycle
        if (graph.hasCycle()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }

        scanner.close();
    }
}
