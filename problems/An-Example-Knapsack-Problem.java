class Solution {
  public static int coinChange(int[] coins, int amount){
    // 各个物品的重量
    int[] weight = {2, 3, 4, 7};
    // 对应的value
    int[] value = {1,3,5,9};
    // 背包最大能放下多少重的物品
    int bagWeight = 10;

    // Step 1: 创建two-dimensional array 
    // 行是number of items: weight.length + 1 ( 因为还要考虑 0） 
    // 列是capacity: bagWeight + 1;
    int[][] dp = new int[weight.length + 1][ bagWeight + 1 ];

    for (int i = 1; i <= weight.length; i++){
      for (int j = 1; j <= bagWeight; j++){
        // Step 2: 背包容量小于当前物品的容量，即背包容量已经不足以拿第i个物品了
        if (j < weight[i-1]) {
          dp[i][j] = dp[i-1][j];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j- weight[i-1]] + value[i-1]);
        }
      }
    }
    System.out.println(dp[weight.length][bagWeight.length]);
    return dp[weight.length][bagWeight.length];//
  }
}


// ============ 背包问题的优化 （滚动数组）================
// 1. j < w[i] 即背包容量小于当前物品的容量
// dp[j] = dp[j]

// 2. j >= w[i] 即背包容量大于等于当前物品的容量
// 2.1 不拿：dp[j] = dp[j] 
// 2.2 拿：dp[j] = dp[ j - w[i]] + c[i] 

