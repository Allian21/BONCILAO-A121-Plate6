//Problem 4

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VertexDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of edges:");
        int n = scanner.nextInt();

        Map<Integer, Integer> degreeMap = new HashMap<>();

        System.out.println("Enter the edges (pair of vertices):");
        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }

        System.out.println("Enter the vertex to find its degree:");
        int vertex = scanner.nextInt();

        int degree = degreeMap.getOrDefault(vertex, 0);
        System.out.println("Degree of vertex " + vertex + " is: " + degree);
    }
}
