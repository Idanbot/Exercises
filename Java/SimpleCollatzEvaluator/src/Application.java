import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please insert a number:");

        int number = input.nextInt();

        collatz(number, 0);
    }

    private static void collatz(int x, int step) {

        System.out.println("Step " + step + " = " + x);

        // this is our end condition for the recursion,
        // n the case X is 1, we stop.
        if (x == 1) {
            return;
        }

        // if X in this step is even, we call collatz again but send x divided by 2
        if ((x % 2) == 0) {
            collatz(x / 2, step + 1);
            // if X in this step is odd, we call collatz again but send 3X+1
        } else {
            collatz(3 * x + 1, step + 1);
        }

    }

}
