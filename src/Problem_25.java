//The Fibonacci sequence is defined by the recurrence relation:
//$ F_n = F_{n-1} + F_{n-2} $, where $ F_1 = 1 $ and $ F_2 = 1 $.
//Hence the first 12 terms will be:
//
// F_1 = 1
// F_2 = 1
// F_3 = 2
// F_4 = 3
// F_5 = 5
// F_6 = 8
// F_7 = 13
// F_8 = 21
// F_9 = 34
// F_{10} = 55
// F_{11} = 89
// F_{12} = 144
//
//The 12th term, $ F_{12} $, is the first term to contain three digits.
//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

import java.math.BigInteger;

public class Problem_25 {
    public static void main(String[] args) {
        System.out.println(thousand_digit_fibonacci_number());
    }

    //My Solution
    public static int thousand_digit_fibonacci_number() {
        BigInteger first = BigInteger.valueOf(1);
        BigInteger second = BigInteger.valueOf(1);
        int index = 2;

        while (true) {
            BigInteger result = first.add(second);
            index++;
            if (result.toString().length() >= 1000) {
                return index;
            }
            first = second;
            second = result;
        }
    }
}

//AI's Solution
//public class Problem_25 {
//    public static void main(String[] args) {
//        System.out.println(thousand_digit_fibonacci_number());
//    }
//
//    public static int thousand_digit_fibonacci_number() {
//        // Approximate index using logarithmic formula
//        double phi = (1 + Math.sqrt(5)) / 2; // Golden ratio
//        double logPhi = Math.log10(phi);
//        double logSqrt5 = Math.log10(Math.sqrt(5));
//        int approxIndex = (int) Math.ceil((999 + logSqrt5) / logPhi);
//
//        // Initialize with approximate starting point
//        BigInteger first = BigInteger.valueOf(1);  // F_1
//        BigInteger second = BigInteger.valueOf(1); // F_2
//        int index = 2;
//
//        // Generate Fibonacci numbers up to the approximate index
//        for (int i = 3; i <= approxIndex + 1; i++) {
//            BigInteger result = first.add(second);
//            if (result.toString().length() >= 1000) {
//                return index + 1; // Return the index when 1000 digits are reached
//            }
//            first = second;
//            second = result;
//            index++;
//        }
//
//        return index; // Fallback (should not be reached with correct approx)
//    }
//}
