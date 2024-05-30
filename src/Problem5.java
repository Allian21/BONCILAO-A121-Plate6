import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem5 {
    public static boolean isBipartite(List<int[]> edges, int n) {
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1 && !bfsCheck(edges, i, colors)) {
                return false;
            }
        }
        return true;
    }

    private static boolean bfsCheck(List<int[]> edges, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                int neighbor = (u == node) ? v : (v == node) ? u : -1;

                if (neighbor != -1) {
                    if (colors[neighbor] == -1) {
                        colors[neighbor] = 1 - colors[node];
                        queue.add(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int m = scanner.nextInt();

        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges (pair of vertices):");
        for (int i = 0; i < m; i++) {
            edges.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }

        System.out.println(isBipartite(edges, n) ? "The graph is bipartite." : "The graph is not bipartite.");
    }
}
