import java.util.Scanner;

public class PascalTriangleMemoization {
private static int[][] P;
private static int pascalNumber (int r, int c) {
    if (P[r][c] != 0) return P[r][c];
    if (c == 0) return 1;
    if (r == c) return 1;
    P[r][c] = pascalNumber(r - 1, c - 1) + pascalNumber(r - 1, c);
    return P[r][c];
}

private static void printPascalTriangle (int n) {
    P = new int[n + 1][n + 1];
    for (int r = 0; r <= n; r++) {
        for (int c = 0; c <= r; c++) {
            System.out.print(pascalNumber(r, c) + " ");
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
