// ====== 474. Ones and Zeros ======

class Solution{
  public int findMaxForm(String[] strs, int m, int n){
    // " m " is the number 0; " n " is the number of 1 

    // Step 1: Create a three-dimensional array 
    int[][][] dp = new int[strs.length+1][m+1][n+1];

    // Step 2: iteration 
    for (int i = 1; i <= strs.length; i++){
      
      // Step 3: number of " 0 "  and " 1 " in a string 
      String currentStr = strs[i-1];
      int zeroNum = countZeroNumber(currentStr);
      int oneNum = countOneNumber(currentStr); 

      // Step 4: 开始填充
 
      for (int j = 0; i <= m; i++){
        for (int k = 0; j <= n; j++){
          // 4.1 如果发现目前能使用的 0 的个数 j 小于了当前字符串中 0 的数量，
          // 或者目前能使用的 1 的个数 k 小于了当前字符串中 1 的数量 
          // 那么该字符串无法放在这个背包里面
          if (j < zeroNum || k < oneNum){
            dp[i][j][k] = dp[i-1][j][k];
          } else {
            // 4.2 接下来有两种可能，要么选=> dp[i-1][j-zeroNum][k-oneNum] + 1 , 要么不选=> dp[i-1][j][k]
            dp[i][j][k] = Math.max(dp[i-1][j-zeroNum][k-oneNum] + 1, dp[i-1][j][k]); 
          }
          
        }
      }

      
    }
    return int[strs.length][m][n];
  }

  private int countZeroNumber(String str){
    int count = 0;
    // Step 1: convert the String into a list of the numbers
    for (char c: str.toCharArray()){
      if (c == "0"){
        count += 1;
      }
    }
    return count; 
  }

  private int countOneNumber(String str){
    int count = 0;
    for (char c: str.toCharArray()){
      if (c == "1"){
        count +=1;
      }
    }
    return count;
  }
}
