// ========= Question: ===========
// Given an integer n, return the least number of perfect square numbers that sum to n.
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

// ========= Solution: ===========
// Dynamic programming dp[i] = square numbers(1) + dp[i-square numbers] 

class Solution {
    public int numSquares(int n) {
        // Create a list to store all perfect square numbers less than or equal to n
        List<Integer> square = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            square.add(idx * idx);
            idx++;
        }

        // dp[i] represents the minimum number of perfect squares that sum to the number i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0; 

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < square.size(); j++) {
                if (square.get(j) > i) {
                    break;
                } 
                // If dp[i] has not yet found the minimum number of perfect squares needed for the number i
                // or if the newly calculated value is smaller, update dp[i]
                if (dp[i] == -1 || dp[i] > dp[i - square.get(j)] + 1) {
                    dp[i] = dp[i - square.get(j)] + 1;
                }
            }
        }
        return dp[n];
    }
}
