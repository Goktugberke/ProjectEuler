//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.

public class Problem_10 {
    public static void main(String[] args) {
        System.out.println(sumPrimes());
    }
    //My Solution
    public static long sumPrimes(){
        long sum = 0;
        for(int i=2;i<=2000000;i++){
            if (checkPrime(i)){
                sum+=i;
            }
        }
        return sum +2;
    }

    public static boolean checkPrime(long n){
        if(n<2){
            return false;
        }
        if(n%2==0){
            return false;
        }
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}

//AI's Solution
class PrimeSumEfficient {
    public static void main(String[] args) {
        int limit = 2_000_000;
        boolean[] isPrime = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            isPrime[i] = true;
        }

        // 0 ve 1 asal değildir
        isPrime[0] = isPrime[1] = false;

        // Eratosthenes eleme yöntemi
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Asal sayıların toplamını hesapla
        long sum = 0;
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }

        System.out.println("The sum of all primes below two million is: " + sum);
    }
}
