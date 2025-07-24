//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(multiples(10));
        System.out.println(multiples(100));
        System.out.println(multiples(12));
        System.out.println(multiples(1000));
        System.out.println(multiples(99));
    }

    //My Answer
    public static int multiples(int i) {
        int sum = 0;
        for (int j = 3; j < i; j++) {
            if (j % 3 == 0 || j % 5 == 0) {
                sum += j;
            }
        }
        return sum;
    }

    //Alternative approach from AI

    public static void alternative(String[] args) {
        int n = 1000; // Upper limit (below 1000)

        // Calculate sum of multiples of 3
        int p3 = (n - 1) / 3; // Number of multiples of 3
        long sum3 = 3L * p3 * (p3 + 1) / 2;

        // Calculate sum of multiples of 5
        int p5 = (n - 1) / 5; // Number of multiples of 5
        long sum5 = 5L * p5 * (p5 + 1) / 2;

        // Calculate sum of multiples of 15 (to subtract overlap)
        int p15 = (n - 1) / 15; // Number of multiples of 15
        long sum15 = 15L * p15 * (p15 + 1) / 2;

        // Apply inclusion-exclusion principle
        long totalSum = sum3 + sum5 - sum15;

        System.out.println("The sum of all multiples of 3 or 5 below " + n + " is: " + totalSum);
    }

}