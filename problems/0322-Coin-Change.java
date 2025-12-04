// ============ Question ============
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.

// Solution: Dynamic programming Given an integer array coins, calculate and return the minimum number of coins needed to make up the total amount.
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // First, initialize all values in the dp array to -1
        Arrays.fill(dp, -1);
        // The minimum number of coins needed to make up 0 is 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                // 1. If the current coin denomination coins[j] is less than or equal to i, 
                //    it means this coin might be used to make up i
                // 2. Then i-coins[j] represents the remaining amount after using a coin of denomination coins[j]
                // 3. dp[i-coins[j]] represents the minimum number of coins needed to make up the amount i-coins[j]
                // 4. If dp[i-coins[j]] != -1, it means there is a valid solution for making up the amount i-coins[j]
                
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i - coins[j]] + 1 < dp[i]) {
                        // Update dp[i]
                        // dp[i] represents the minimum number of coins needed to make up i
                        // This is obtained by taking 1 coin of denomination coins[j]
                        // Plus the minimum dp[i - coins[j]] coins needed to make up i - coins[j]
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        // dp[amount] represents the minimum number of coins needed to make up the total amount
        return dp[amount];
        
    }
}
