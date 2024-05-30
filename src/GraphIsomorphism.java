import java.util.*;

public class GraphIsomorphism {
    private static boolean areIsomorphic(int[][] adjMatrix1, int[][] adjMatrix2) {
        int n = adjMatrix1.length;

        // Simple check if dimensions match
        if (adjMatrix1.length != adjMatrix2.length || adjMatrix1[0].length != adjMatrix2[0].length) {
            return false;
        }

        // Generate all possible permutations of vertices
        List<int[]> permutations = generatePermutations(n);
        for (int[] perm : permutations) {
            if (checkPermutation(adjMatrix1, adjMatrix2, perm)) {
                return true;
            }
        }
        return false;
    }

    private static List<int[]> generatePermutations(int n) {
        List<int[]> result = new ArrayList<>();
        permute(n, new int[n], new boolean[n], 0, result);
        return result;
    }

    private static void permute(int n, int[] current, boolean[] used, int depth, List<int[]> result) {
        if (depth == n) {
            result.add(current.clone());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                current[depth] = i;
                permute(n, current, used, depth + 1, result);
                used[i] = false;
            }
        }
    }

    private static boolean checkPermutation(int[][] adjMatrix1, int[][] adjMatrix2, int[] perm) {
        int n = adjMatrix1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix1[i][j] != adjMatrix2[perm[i]][perm[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        System.out.println("Enter the adjacency matrix for the first graph:");
        int[][] adjMatrix1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        int[][] adjMatrix2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix2[i][j] = scanner.nextInt();
            }
        }

        if (areIsomorphic(adjMatrix1, adjMatrix2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }
}
