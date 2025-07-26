//Sum Square Difference
//The sum of the squares of the first ten natural numbers is,1² + 2² + ... + 10² = 385. The square of the sum of the first
//ten natural numbers is,(1 + 2 + ... + 10)² = 55² = 3025.Hence the difference between the sum of the squares of the first
//ten natural numbers and the square of the sum is3025 - 385 = 2640. Find the difference between the sum of the squares of
//the first one hundred natural numbers and the square of the sum.
public class Problem_6 {
    public static void main(String[] args) {
        System.out.println(sumSquareDifference(10));
        System.out.println(sumSquareDifference(100));
    }

    //My Solution
    //Note :  Because of problem's complexity is small, I did not care for single responsibility for methods as AI.
    public static int sumSquareDifference(int num) {
        int sum = 0;
        int sumOfSquares = 0;
        int squareOfSums = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
            sumOfSquares += i * i;
        }
        squareOfSums = sum * sum;
        return squareOfSums - sumOfSquares;
    }
}

//AI's Solution
class SumSquareDifference {
    public static long sumOfSquares(int n) {
        // Formula: n (n + 1) (2n + 1) / 6
        return (long) n * (n + 1) * (2 * n + 1) / 6;
    }

    public static long squareOfSum(int n) {
        // Formula: (n (n + 1) / 2) ^ 2
        long sum = (long) n * (n + 1) / 2;
        return sum * sum;
    }

    public static void main(String[] args) {
        int n = 100; // First 100 natural numbers
        long sumSquares = sumOfSquares(n);
        long squareSum = squareOfSum(n);
        long difference = squareSum - sumSquares;

        System.out.println("Sum of squares of the first " + n + " natural numbers: " + sumSquares);
        System.out.println("Square of the sum of the first " + n + " natural numbers: " + squareSum);
        System.out.println("Difference: " + difference);
    }
}
