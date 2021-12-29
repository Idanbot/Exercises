import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibApproaches {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        long start = 0;

        System.out.println("Please select a method to execute:\n" +
                           "1: Recursive Fibonacci using memoization.\n" +
                           "2: Recursive Fibonacci using memoization and BigInteger.\n" +
                           "3: Tail recursion of Fibonacci using BigInteger.\n");

        int selection = input.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Please enter a number:");
                long n = input.nextLong();
                start = System.currentTimeMillis();

                System.out.println(longFib(n, new HashMap<>()));
                break;

            case 2:
                System.out.println("Please enter a number:");
                input.nextLine();
                BigInteger bigN = new BigInteger(input.nextLine());
                start = System.currentTimeMillis();

                System.out.println(fib(bigN, new HashMap<>()));
                break;

            case 3:
                System.out.println("Please enter a number:");
                long tailN = input.nextLong();
                start = System.currentTimeMillis();

                System.out.println(tailFib(tailN, BigInteger.ZERO, BigInteger.ONE));
                break;

            default:
                System.out.println("Didn't select a value between 1-3, closing.");
                System.exit(0);
        }


        System.out.println(System.currentTimeMillis() - start + " ms");

        input.close();
    }

//	Recursive Fibonacci for index 'n', optimized with memoization using HashMap.
	public static long longFib(long n, Map<Long, Long> map) {

        if(n < 0)
            throw new IllegalArgumentException("Are you trying to trick me?");

        if (map.containsKey(n)) {
			return map.get(n);
		}

		if (n <= 2) {
			return 1;
		}

		long memo = longFib(n - 1, map) + longFib(n - 2, map);
		map.put(n, memo);
		return memo;
	}

    //	BigInt Recursive Fibonacci for index 'n', optimized with memoization using HashMap.
    public static BigInteger fib(BigInteger n, Map<BigInteger, BigInteger> map) {

        if(n.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException("Are you trying to trick me?");

        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }

        BigInteger memo = fib(n.subtract(BigInteger.ONE), map).add(fib(n.subtract(BigInteger.TWO), map));
        map.put(n, memo);
        return memo;
    }


    //	BigInt Tail Recursion of Fibonacci value.
    public static BigInteger tailFib(long n,BigInteger a, BigInteger b){

        if(n < 0)
            throw new IllegalArgumentException("Are you trying to trick me?");

        if(n == 0)
            return a;

        if(n == 1)
            return b;

        return tailFib(n-1,b,a.add(b));
    }
}
