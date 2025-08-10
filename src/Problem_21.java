//Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
//If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors
//of 284 are 1, 2, 4, 71 and 142; so d(284) = 220. Evaluate the sum of all the amicable numbers under 10000.
public class Problem_21 {
    public static void main(String[] args) {
        System.out.println(amicable_number(500));
    }

    //My Solution
    public static int sum_divisor(int n) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }

    public static int amicable_number(int n) {
        int totalSum = 0;
        boolean[] isAmicable = new boolean[n + 1];

        for (int a = 1; a <= n; a++) {
            int b = sum_divisor(a);
            if (b <= n && b != a && !isAmicable[a] && sum_divisor(b) == a) {
                totalSum += a;
                if (b <= n) totalSum += b;
                isAmicable[a] = true;
                isAmicable[b] = true;
            }
        }

        return totalSum;
    }
}

//AI's Solution

//import java.util.HashSet;
//import java.util.Set;
//
//public class OptimizedAmicableNumbers {
//    public static void main(String[] args) {
//        int limit = 10000;
//        int[] sumProperDivisors = new int[limit + 1];
//
//        // Sum of all divisors'ı hesapla (σ(n))
//        for (int i = 1; i <= limit; i++) {
//            for (int j = i; j <= limit; j += i) {
//                sumProperDivisors[j] += i;
//            }
//        }
//
//        // Proper divisors sum = σ(n) - n
//        for (int i = 1; i <= limit; i++) {
//            sumProperDivisors[i] -= i;
//        }
//
//        Set<Integer> amicableNumbers = new HashSet<>();
//        for (int a = 1; a <= limit; a++) {
//            int b = sumProperDivisors[a];
//            if (b > a && b <= limit && sumProperDivisors[b] == a) {
//                amicableNumbers.add(a);
//                amicableNumbers.add(b);
//            }
//        }
//
//        long totalSum = 0;
//        for (int num : amicableNumbers) {
//            totalSum += num;
//        }
//
//        System.out.println("Sum of all amicable numbers under " + limit + ": " + totalSum);
//    }
//}