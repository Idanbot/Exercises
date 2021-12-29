import java.util.Scanner;

public class InverseConcentricSquare {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please insert size for array");
        int runner = input.nextInt();
        input.close();

		int n = 1;
        int size = 2 * runner - 1;
        int start = 0;
        int end = size - 1;

        int[][] a = new int[size][size];

        while (n != runner + 1) {
            for (int i = start; i <= end; i++) {
                for (int j = start; j <= end; j++) {
                    if ((i == start) || (j == start) || (i == end) || (j == end))
                        a[i][j] = n;
                }
            }

            start++;
            end--;
            n++;

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

}
