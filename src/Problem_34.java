//145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//Note: As 1! = 1 and 2! = 2 are not sums they are not included.
public class Problem_34 {

    // My Solution
    public static void main(String[] args) {
        int totalSum = 0;

        for (int i = 10; i <= 999999; i++) {
            String number = Integer.toString(i);
            long sum = 0;

            for (int j = 0; j < number.length(); j++) {
                int digit = number.charAt(j) - '0';
                sum += calculateFactorial(digit);
            }

            if (sum == i) {
                System.out.println(i);
                totalSum += i;
            }
        }

        System.out.println("Total sum: " + totalSum);
    }

    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) return 1;

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

//AI's Solution
class FactorialDigitSum {
    // Precompute factorials for digits 0-9
    private static final int[] FACTORIALS = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static void main(String[] args) {
        int sum = 0;
        // Upper limit based on max factorial sum (e.g., 9! * 5 digits ~ 1.8 million)
        for (int num = 10; num < 1000000; num++) {
            if (isCuriousNumber(num)) {
                sum += num;
            }
        }
        System.out.println(sum);
    }

    private static boolean isCuriousNumber(int num) {
        int original = num;
        int digitSum = 0;
        while (num > 0) {
            int digit = num % 10;
            digitSum += FACTORIALS[digit];
            num /= 10;
            // Early termination if sum exceeds original number
            if (digitSum > original) return false;
        }
        return digitSum == original;
    }
}