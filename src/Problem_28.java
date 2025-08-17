//Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
//        21 22 23 24 25
//        20  7  8  9 10
//        19  6  1  2 11
//        18  5  4  3 12
//        17 16 15 14 13
//It can be verified that the sum of the numbers on the diagonals is 101.
//What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

//My Solution
public class Problem_28 {
    static int currentNumber;

    public static void main(String[] args) {
        number_spiral_diagonals(5);
        System.out.println("\nDiagonal sum for 1001x1001:");
        number_spiral_diagonals(1001);
    }

    public static void number_spiral_diagonals(int n){
        int [][] spiral = new int [n][n];
        currentNumber = n * n;

        // Start from top-right corner
        spiral[0][n-1] = currentNumber--;

        callRightToLeft(spiral, 0, n-1, 0);

        if (n <= 25) {
            displayArray(spiral);
        }

        long diagonalSum = calculateDiagonalSum(spiral);
        System.out.println("Diagonal sum: " + diagonalSum);
    }

    public static void callRightToLeft(int [][] spiral, int a, int b, int layer){
        // Move left from current position
        for(int j = b - 1; j >= layer; j--){
            spiral[a][j] = currentNumber--;
        }
        // After reaching left edge, go down
        callUpToDown(spiral, a, layer, layer);
    }

    public static void callUpToDown(int [][] spiral, int a, int b, int layer){
        // Move down from current position
        for(int i = a + 1; i <= spiral.length - 1 - layer; i++){
            spiral[i][b] = currentNumber--;
        }
        // After reaching bottom, go right
        callLeftToRight(spiral, spiral.length - 1 - layer, b, layer);
    }

    public static void callLeftToRight(int [][] spiral, int a, int b, int layer){
        // Move right from current position
        for(int j = b + 1; j <= spiral.length - 1 - layer; j++){
            spiral[a][j] = currentNumber--;
        }
        // After reaching right edge, go up
        callDownToUp(spiral, a, spiral.length - 1 - layer, layer);
    }

    public static void callDownToUp(int[][] spiral, int a, int b, int layer) {
        // Move up from current position (but don't overwrite the starting position of this layer)
        for (int i = a - 1; i > layer; i--) {
            spiral[i][b] = currentNumber--;
        }

        // Check if we need to go to next inner layer
        int nextLayer = layer + 1;
        if (nextLayer < spiral.length / 2) {
            // Start next layer from top-right of inner rectangle
            spiral[nextLayer][spiral.length - 1 - nextLayer] = currentNumber--;
            callRightToLeft(spiral, nextLayer, spiral.length - 1 - nextLayer, nextLayer);
        } else if (nextLayer == spiral.length / 2 && spiral.length % 2 == 1) {
            // Place center element for odd-sized spiral
            spiral[spiral.length / 2][spiral.length / 2] = currentNumber--;
        }
    }

    public static long calculateDiagonalSum(int[][] spiral) {
        long sum = 0;
        int n = spiral.length;

        for (int i = 0; i < n; i++) {
            sum += spiral[i][i];
        }

        for (int i = 0; i < n; i++) {
            sum += spiral[i][n - 1 - i];
        }

        if (n % 2 == 1) {
            sum -= spiral[n / 2][n / 2];
        }

        return sum;
    }

    public static void displayArray(int [][] spiral){
        for(int i=0; i<spiral.length; i++){
            for(int j=0; j<spiral[0].length; j++){
                System.out.print(spiral[i][j]+" ");
            }
            System.out.println();
        }
    }
}

//AI's Solution
class AISolution {
    public static void main(String[] args) {
        System.out.println("5x5 Spiral diagonal sum: " + calculateDiagonalSum(5));
        System.out.println("1001x1001 Spiral diagonal sum: " + calculateDiagonalSum(1001));
    }

    public static long calculateDiagonalSum(int n) {
        if (n == 1) return 1;

        long sum = 1; // Center element

        // For each layer (ring) from innermost to outermost
        for (int layer = 1; layer <= n / 2; layer++) {
            int sideLength = 2 * layer + 1;

            // Bottom-right corner of this layer
            long bottomRight = (long) sideLength * sideLength;

            // Calculate the four corners of this layer
            long topRight = bottomRight - (sideLength - 1);
            long topLeft = bottomRight - 2 * (sideLength - 1);
            long bottomLeft = bottomRight - 3 * (sideLength - 1);

            // Add all four corners to sum
            sum += topRight + topLeft + bottomLeft + bottomRight;
        }

        return sum;
    }

    // Alternative mathematical formula (even more optimal)
    public static long calculateDiagonalSumFormula(int n) {
        if (n == 1) return 1;

        // Mathematical formula: (4n^3 + 3n^2 + 8n - 9) / 6
        long nLong = n;
        return (4 * nLong * nLong * nLong + 3 * nLong * nLong + 8 * nLong - 9) / 6;
    }

    // For verification: generate actual spiral (only for small n)
    public static long calculateDiagonalSumBruteForce(int n) {
        if (n > 101) {
            throw new IllegalArgumentException("Brute force method only for n <= 101");
        }

        int[][] spiral = new int[n][n];

        // Start from center
        int x = n / 2, y = n / 2;
        spiral[x][y] = 1;

        // Direction vectors: right, down, left, up (clockwise)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int direction = 0;

        int num = 1;
        int steps = 1;

        while (num < n * n) {
            for (int i = 0; i < 2 && num < n * n; i++) {
                for (int j = 0; j < steps && num < n * n; j++) {
                    x += dx[direction];
                    y += dy[direction];

                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        spiral[x][y] = ++num;
                    }
                }
                direction = (direction + 1) % 4;
            }
            steps++;
        }

        // Calculate diagonal sum
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += spiral[i][i]; // Main diagonal
            sum += spiral[i][n - 1 - i]; // Anti-diagonal
        }

        // Subtract center once for odd n (counted twice)
        if (n % 2 == 1) {
            sum -= spiral[n / 2][n / 2];
        }

        return sum;
    }

    // Test all three methods for verification
    public static void verifyMethods() {
        System.out.println("Verification for small values:");
        for (int n = 1; n <= 11; n += 2) { // Test odd values only
            long bruteForce = calculateDiagonalSumBruteForce(n);
            long layerMethod = calculateDiagonalSum(n);
            long formulaMethod = calculateDiagonalSumFormula(n);

            System.out.printf("n=%d: BruteForce=%d, Layer=%d, Formula=%d%n",
                    n, bruteForce, layerMethod, formulaMethod);
        }
    }
}