// Questions: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Solution: Dynamic Programming -- Define subproblem: maximum money that can be stolen from k houses
// [1] Rob only the first k-1 houses, don't rob the last house
// [2] Rob only the first k-2 houses, then rob the last house

// --------------- Solution I - Java: -------------------------------

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}

// --------------- Solution II - Java: -------------------------------
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] value = new int[nums.length+1];
        value[0] = 0;
        value[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            value[i] = Math.max(value[i - 1], value[i - 2] + nums[i]);
        }
        return value[n];
    }
}



