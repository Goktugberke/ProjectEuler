//Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
//
//        1634 = 1^4 + 6^4 + 3^4 + 4^4
//        8208 = 8^4 + 2^4 + 0^4 + 8^4
//        9474 = 9^4 + 4^4 + 7^4 + 4^4
//
//As 1 = 1^4 is not a sum it is not included.
//
//The sum of these numbers is 1634 + 8208 + 9474 = 19316.
//
//Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.


public class Problem_30 {
    public static void main(String[] args) {
        System.out.println(digitFifthPowers());
    }

    public static int digitFifthPowers() {
        int result = 0;
        int power = 5;
        int maxDigitPow = (int) Math.pow(9, power);
        int upperBound = 0;

        for (int n = 1; ; n++) {
            if (n * maxDigitPow < Math.pow(10, n - 1)) {
                upperBound = (n - 1) * maxDigitPow;
                break;
            }
        }

        int[] pow = new int[10];
        for (int d = 0; d <= 9; d++) {
            pow[d] = (int) Math.pow(d, power);
        }

        for (int i = 10; i <= upperBound; i++) {
            int temp = i;
            long sum = 0;
            while (temp > 0) {
                int digit = temp % 10;
                sum += pow[digit];
                temp /= 10;
            }
            if (sum == i) {
                result+=i;
                System.out.println(i);
            }
        }
        System.out.println("-----------------");
        return result;
    }
}
