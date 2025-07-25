public class Problem_3 {

  //  Question : The prime factors of 13195 are 5, 7, 13 and 29.What is the largest prime factor of the number 600851475143 ?

    public static void main(String[] args) {
        System.out.println(largestPrime(13195));
        System.out.println(largestPrime(600851475143L));
    }

    public static long largestPrime(long num) {
        long res = 1;
        for (long i = 2; i * i <= num; i++) {
            if (isPrime(i) && num % i == 0) {
                res = Math.max(i, largestPrime(num / i));
            }
        }
        if (isPrime(num)) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
