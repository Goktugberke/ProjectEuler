public class Problem_2 {
    public static void main(String[] args) {
        System.out.println(fibonacci());
        //result is = 4613732
    }

    //my way
    public static int fibonacci() {
        int[] fibonacci;
        int i = 1;
        int j = 1;
        int sum = 0;
        while (i < 4000000) {
            int temp = j;
            j += i;
            i= temp;
            if(j %2 == 0){
                sum+=j;
            }
        }
        return sum;
    }

    //AI's solution :
    public static void AI(String[] args) {
        long limit = 4_000_000; // Upper limit for Fibonacci terms
        long sum = 0; // Sum of even-valued terms
        long a = 1; // First term
        long b = 2; // Second term

        // Include the first even term (2) if it is even
        if (b % 2 == 0) {
            sum += b;
        }

        // Generate Fibonacci numbers until exceeding the limit
        while (b <= limit) {
            long next = a + b; // Next Fibonacci number
            if (next > limit) {
                break; // Exit if next term exceeds limit
            }
            if (next % 2 == 0) {
                sum += next; // Add even term to sum
            }
            a = b; // Update a to the next term
            b = next; // Update b to the next term
        }

        System.out.println("The sum of even-valued Fibonacci terms not exceeding 4,000,000 is: " + sum);
    }
}
