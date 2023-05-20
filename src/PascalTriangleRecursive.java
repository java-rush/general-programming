import java.util.Scanner;

public class PascalTriangleRecursive {
    private static int pascalNumber (int r, int c) {
        if (c == 0) return 1;
        if (r == c) return 1;
        return pascalNumber(r - 1, c - 1) + pascalNumber(r - 1, c);
    }

    private static void printPascalTriangle (int n) {
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
