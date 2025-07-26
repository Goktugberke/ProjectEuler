//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.What is
// the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class Problem_5 {
    public static void main(String[] args) {
        System.out.println(smallestDivisible(10));
        System.out.println(smallestDivisible(20));
    }

    //My Solution
    public static int smallestDivisible(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                int temp = i;
                while (temp <= num) {

                    if (temp * i >= num) {
                        break;
                    } else {
                        temp *= i;
                    }
                }
                result *= temp;
            }
        }
        return result;
    }

    public static boolean isPrime(int a) {
        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    //AI's Solution
    class SmallestMultiple {
        // Function to compute GCD using Euclidean algorithm
        public static long gcd(long a, long b) {
            while (b != 0) {
                long temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        // Function to compute LCM of two numbers
        public static long lcm(long a, long b) {
            return (a * b) / gcd(a, b);
        }

        public static void main(String[] args) {
            int n = 20; // Range from 1 to 20
            long result = 1; // Start with 1 (neutral for LCM)

            // Compute LCM for numbers 1 to 20
            for (int i = 1; i <= n; i++) {
                result = lcm(result, i);
            }

            System.out.println("The smallest positive number divisible by all numbers from 1 to " + n + " is: " + result);
        }
    }

}
