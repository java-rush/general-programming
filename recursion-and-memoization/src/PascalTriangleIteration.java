import java.util.Scanner;

public class PascalTriangleIteration {
private static void printPascalTriangle (int n) {
    int[][] P = new int[n + 1][n + 1];
    for (int r = 0; r <= n; r++) {
        P[r][0] = 1;
        P[r][r] = 1;
        for (int c = 1; c < r; c++) {
            P[r][c] = P[r - 1][c - 1] + P[r - 1][c];
        }
    }
    for (int r = 0; r <= n; r++) {
        for (int c = 0; c <= r; c++) {
            System.out.print(P[r][c] + " ");
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPascalTriangle(n);
    }
}
