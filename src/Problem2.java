//Problem 2

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Asks for input
        System.out.print("Enter the number of vertices: ");
        int numVertices = inputScanner.nextInt();

        // Creates and fills the adjacency matrix
        int[][] adjMatrix = new int[numVertices][numVertices];
        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = inputScanner.nextInt();
            }
        }

        // a hashmap to store the edges and frequencies of them
        Map<String, Integer> edgeFrequency = new HashMap<>();

        // to traverse the matrix to count the edges
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] != 0) {
                    // no repeated edge
                    String edge = (i < j) ? i + " - " + j : j + " - " + i;
                    edgeFrequency.put(edge, edgeFrequency.getOrDefault(edge, 0) + adjMatrix[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and Counts:");
        edgeFrequency.forEach((edge, count) ->
                System.out.println("Edge - " + edge + " appears " + count + " times")
        );

        inputScanner.close();
    }
}
