// ========= Question: ===========
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution {
    public int climbStairs(int n) {
        // To avoid index out of bounds when n = 0, ensure dp[1] and dp[2] have valid values
        int[] stair = new int[n + 2];
        // Initialize dp[1] and dp[2]
        stair[1] = 1;
        stair[2] = 2;
        for (int i = 3; i <= n; i++) {
            stair[i] = stair[i - 1] + stair[i - 2];
        }
        return stair[n];
    }
}
