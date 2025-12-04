// ============= Question: ============
// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Solution: Dynamic programming. If the maximum sum ending at dp[i-1] is negative, don't include it; otherwise, add nums[i] to it.
// During the iteration, if the maximum subarray sum ending at nums[i] is positive, then the maximum subarray sum ending at the i-th element is itself plus the maximum subarray sum ending at the previous element.


// ============= Java Code 1 ============
class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] represents the maximum subarray sum ending at index i
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // Track the overall maximum sum found
        int maxNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the existing subarray or start a new one at the current element
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // Update the overall maximum
            maxNum = Math.max(maxNum, dp[i]);
        }
        
        return maxNum;
    }
}

// ============= Java Code 2 ============
class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] represents the maximum subarray sum ending at index i
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // Track the overall maximum sum found
        int maxNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]>0){
              dp[i] = dp[i-1] + nums[i];            
            } else {
              dp[i] = nums[i];
            }
            if (maxNum < dp[i]){
              maxNum = dp[i];
            }
        }
        
        return maxNum;
    }
}
