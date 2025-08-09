//n! means n × (n - 1) × ... × 3 × 2 × 1.
//For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//Find the sum of the digits in the number 100!.

import java.math.BigInteger;

public class Problem_20 {
    public static void main(String[] args) {
        System.out.println(factorial_digit_sum(100));
    }

    public static int factorial_digit_sum(int n) {
        BigInteger num = new BigInteger("1");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            num = num.multiply(BigInteger.valueOf(i));
        }

        //My Solution
        for(char c: num.toString().toCharArray() ){
            sum += Character.getNumericValue(c);
        }

        //AI's Solution Differs from my solution only in here :
//        String numStr = num.toString();
//        return numStr.chars().map(ch -> ch - '0').sum();
        return sum;
    }
}
