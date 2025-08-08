//Starting in the top left corner of a 2x2 grid, and only being able to move to the right and down, there are exactly
//routes to the bottom right corner. How many such routes are there through a 20x20 grid?

public class Problem_15 {
    public static void main(String[] args) {
        System.out.println(lattice_paths(20));
    }

    //My Solution
    public static int lattice_paths(int n) {
        int[][] dp = new int[n + 1][n + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n][n];
    }
}