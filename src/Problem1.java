//Problem 1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
    private int numV; // Number of vertices
    private List<List<Integer>> adjList; // Adjacency List

    public Problem1(int numV) {
        this.numV = numV;
        adjList = new ArrayList<>();
        for (int i = 0; i < numV; ++i) {
            adjList.add(new ArrayList<>());
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1); // For an undirected graph, add both directions
    }

    // A DFS based function to visit all reachable vertices from v
    public void dfs(int v, boolean visited[]) {
        visited[v] = true;
        for (int n : adjList.get(v)) {
            if (!visited[n])
                dfs(n, visited);
        }
    }

    // Function that returns true if the graph is connected, else false
    public boolean isConnected() {
        boolean visited[] = new boolean[numV];
        Arrays.fill(visited, false);

        // Perform Depth-First Search starting from vertex 0
        dfs(0, visited);

        // If any vertex is unvisited, then the graph is not connected
        for (int i = 0; i < numV; ++i)
            if (!visited[i])
                return false;

        return true;
    }

    // Function to find the number of connected components
    public int countConnectedComponents() {
        boolean visited[] = new boolean[numV];
        int count = 0;

        // Traverse through all vertices
        for (int i = 0; i < numV; ++i) {
            if (!visited[i]) {
                // If vertex i is not visited, then a new connected component is found
                dfs(i, visited);
                count++;
            }
        }

        return count;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices in the graph: ");
        int Vertex = scanner.nextInt();
        Problem1 graph = new Problem1(Vertex);
        System.out.print("Enter the number of edges: ");
        int Edges = scanner.nextInt();
        System.out.println("Enter the edges (vertex1 vertex2): ");
        for (int i = 0; i < Edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.addEdge(v1, v2);
        }
        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            int connectedComponents = graph.countConnectedComponents();
            System.out.println("Number of connected components: " + connectedComponents);
        }
    }
}
