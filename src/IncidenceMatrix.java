//Problem 7

import java.util.Scanner;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int m = scanner.nextInt();

        int[][] incMatrix = new int[n][m];

        System.out.println("Enter the edges (pair of vertices):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            incMatrix[u][i]++;
            incMatrix[v][i]++;
        }

        System.out.println("Incidence Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(incMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
