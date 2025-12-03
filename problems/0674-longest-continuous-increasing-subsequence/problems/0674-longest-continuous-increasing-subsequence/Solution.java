// Given an unsorted array of integers, find the longest continuous increasing subsequence and return its length.
// A continuous increasing subsequence can be determined by two indices l and r (l < r).
// If for each l <= i < r, nums[i] < nums[i + 1], then [nums[l], nums[l+1], ..., nums[r-1], nums[r]] is a continuous increasing subsequence.
// dp[i] represents the length of the longest continuous increasing sequence ending at nums[i]

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // Initialize dp array to store the length of continuous increasing sequence at each index
        int[] dp = new int[nums.length];
        // Track the maximum length found
        int maxLength = 1;

        // Initialize all dp values to 1 (each element is at least a sequence of length 1)
        Arrays.fill(dp, 1);

        // Iterate through array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            // If current element is greater than previous, extend the sequence
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            // Update the maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
