// Question: Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// Solution: Dynamic Programming 
// Step 1:
// [1] Modify the first L1-1 characters of word1 to match the first L2-1 characters of word2, then replace character a with b: word1(L1-1) --> word2(L2-1)
// [2] Modify the first L1-1 characters of word1 to match word2, then delete character a: word1(L1-1) --> word2(L2)
// [3] Modify the first L1 characters of word1 to match the first L2-1 characters of word2, then insert character b: word1(L1) --> word2(L2-1)
// Step 2:
// Choose the minimum value, then determine whether to perform an insertion, deletion, or replacement operation

class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j] represents the minimum number of operations needed to convert the first i characters of word1 to the first j characters of word2
        int L1 = word1.length(); 
        int L2 = word2.length();

        int[][] dp = new int[L1 + 1][L2 + 1];

        // Initialize: convert word1[0...i-1] to empty string requires i deletions
        for (int i = 0; i <= L1; i++) {
            dp[i][0] = i;
        }
        // Initialize: convert empty string to word2[0...j-1] requires j insertions
        for (int j = 0; j <= L2; j++) {
            dp[0][j] = j;
        }

        // Fill the dp table
        for (int i = 1; i <= L1; i++) {
            for (int j = 1; j <= L2; j++) {
                // If characters match, no operation needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Choose minimum among: replace, delete, or insert
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[L1][L2];
    }
}
