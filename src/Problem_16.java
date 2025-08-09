//2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//What is the sum of the digits of the number 2^1000?

import java.math.BigInteger;

public class Problem_16 {
    public static void main(String[] args) {
        power_digits_sum(2,1000);
    }

    public static void power_digits_sum(int base, int power) {
        BigInteger num = new BigInteger(String.valueOf(base)).pow(power);
        String numStr = num.toString();
        int sum = 0;

        for (char digit : numStr.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }

        System.out.println(base + "^" + power + " rakamlarının toplamı: " + sum);
    }
}
