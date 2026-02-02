/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Ryan
 */

public class MakingChange {
//    public static long countWays(int target, int[] coins) {
//        long[][] memo = new long[target + 1][coins.length];
//
//        return count(target, coins.length-1, coins, memo);
//    }
//
//    // Recursive function
//    public static long count(int sum, int index, int[] coins, long[][] memo) {
//        // Base cases
//        if (sum == 0)
//            return 1;
//
//        if (index < 0)
//            return 0;
//
//        if (sum < 0)
//            return 0;
//
//        if (memo[sum][index] == 0) {
//            memo[sum][index] = count(sum - coins[index], index, coins, memo) + count(sum, index - 1, coins, memo);
//            return memo[sum][index];
//        }
//
//        return memo[sum][index];
//    }


    public static long countWays(int target, int[] coins) {
        long[][] tabs = new long[target + 1][coins.length];

        // Fill in the first column with 1's because that is a "base case" in this scenario
        for (int i = 0; i < coins.length; i++) {
            tabs[0][i] = 1;
        }

        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                // Prevents out of bounds
                if (i - coins[j] >= 0) {
                    // Add the included case
                    tabs[i][j] += tabs[i - coins[j]][j];
                }
                // Prevents out of bounds
                if (j - 1 >= 0) {
                    // Add the excluded case
                    tabs[i][j] += tabs[i][j-1];
                }
            }
        }

        return tabs[target][coins.length - 1];
    }
}