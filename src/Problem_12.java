public class Problem_12 {
    public static void main(String[] args) {
        System.out.println(getTriangleNum(highlyDivisibleTriangleNumber() ));
    }

    public static long highlyDivisibleTriangleNumber() {
        long n = 1;
        while (true) {
            long triangleNum = n * (n + 1) / 2;
            int divisorCount = countDivisors(triangleNum);
            if (divisorCount > 500) {
                return n;
            }
            n++;
        }
    }

    public static int countDivisors(long num) {
        int count = 0;
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count += (i * i == num) ? 1 : 2;
            }
        }
        return count;
    }

    public static long getTriangleNum(long n) {
        return n * (n + 1) / 2;
    }
}

//AI's Solution
class Problem_12AI {
    public static void main(String[] args) {
        System.out.println(getTriangleNum(findHighlyDivisibleTriangleNumber()));
    }

    public static long findHighlyDivisibleTriangleNumber() {
        long left = 1, right = 20000; // Tahmini üst sınır
        while (left < right) {
            long mid = left + (right - left) / 2;
            long triangleNum = mid * (mid + 1) / 2;
            int divisorCount = countDivisors(triangleNum);
            if (divisorCount > 500) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int countDivisors(long num) {
        int count = 1;
        for (long i = 2; i * i <= num; i++) {
            int power = 0;
            while (num % i == 0) {
                power++;
                num /= i;
            }
            count *= (power + 1);
            if (num == 1) break;
        }
        if (num > 1) count *= 2; // Kalan asal sayı için
        return count;
    }

    public static long getTriangleNum(long n) {
        return n * (n + 1) / 2;
    }
}