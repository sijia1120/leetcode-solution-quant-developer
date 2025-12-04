// Question: Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers. Return the maximum product you can get.

// Solution: Using dynamic programming where dp[i] represents the maximum product of the positive integer i after breaking it down
// dp[i] can be the maximum of (i-j)*j and dp[i-j]*j

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1 * 1; 
        
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // For the positive integer i, there are two ways to break it:
                // 1. j * (i-j) represents breaking i into two numbers: j and (i-j)
                // 2. j * dp[i-j] represents breaking i into j and the maximum product of (i-j)
                // dp[i-j] represents the maximum product of the positive integer (i-j) after breaking it down
                // After obtaining this product, multiply it by j
                // Note: the product after breaking down is not necessarily greater than i
                // For example, when i=2, the product after breaking down is 1
                // Therefore, we need to compare these options and take the maximum
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n]; 
    }
}
