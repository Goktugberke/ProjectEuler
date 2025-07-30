//A Pythagorean triplet is a set of three natural numbers, $a < b < c$, for which $a^2 + b^2 = c^2$.
//For example, $3^2 + 4^2 = 9 + 16 = 25 = 5^2$.There exists exactly one Pythagorean triplet for
//which $a + b + c = 1000$. Find the product $abc$.

public class Problem_9 {
    public static void main(String[] args) {
    pythagoreanTriplerAI();
    }


    //My Solution
    public static void pythagoreanTripler(){
        long  startTime = System.currentTimeMillis();;
        for (int i=1;i<=500;i++){
            for (int j=1;j<=500;j++){
                for (int k=1;k<=500;k++){
                    if(i+j+k==1000 && (i*i + j*j == k*k || i*i == j*j +k*k || i*i + k*k ==j*j)){
                        System.out.println(i*j*k);
                        System.out.println( "i : "+i +"j : "+j +"k : "+k );
                    }
                }
            }
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }

    //AI' Solution
    public static void pythagoreanTriplerAI() {
        long startTime = System.currentTimeMillis();
        for (int a = 1; a <= 333; a++) {
            for (int b = a + 1; b <= (1000 - a) / 2; b++) {
                int c = 1000 - a - b;
                if (a * a + b * b == c * c) {
                    System.out.println(a * b * c);
                    System.out.println("a: " + a + ", b: " + b + ", c: " + c);
                }
            }
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (stopTime - startTime) + " ms");
    }
}

