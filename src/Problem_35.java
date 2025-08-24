//The number 197 is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
//There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//How many circular primes are there below one million?

public class Problem_35 {
    public static void main(String[] args) {
        System.out.println(countCircularPrimes(1000000));
    }

    public static int countCircularPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isCircularPrime(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean isCircularPrime(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            int rotated = Integer.parseInt(s.substring(i) + s.substring(0, i));
            if (!isPrime(rotated)) return false;
        }
        return true;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}
