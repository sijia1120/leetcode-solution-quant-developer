// ===   Question:   ===
// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

// ===   Solution:  ===

class Solution {
    public String multiply(String num1, String num2) {

        // Edge case handling: any number multiplied by 0 equals 0
        if (num1.equals("0") || num2.equals("0")) return "0";

        // Get the length of the strings
        int m = num1.length();
        int n = num2.length();

        int[] ansArr = new int[m + n];

        // Access elements in num1 from right to left
        for (int i = m-1; i >= 0; i--){
            // Get the digit, equivalent to converting character to integer
            int x = num1.charAt(i) - 48;
            for (int j = n-1; j >= 0; j--){
                int y = num2.charAt(j) - 48;
                ansArr[i + j + 1] += x * y;
            }
        }

        // Next, we need to process each position in ansArr to ensure each position stores only a single digit
        for (int k =  m +n-1; k > 0; k--){
            ansArr[k-1] += ansArr[k] / 10;
            ansArr[k] %= 10;
        }

        // Finally, convert the result to a string
        StringBuffer ans = new StringBuffer();
        // Start from the most significant digit. We need to check if ansArr[0] is 0; if it is, skip this position and start from the next position
        int index = ansArr[0] == 0? 1:0;

        // Continuously fill the string
        while (index < m + n){
            ans.append(ansArr[index]);
            index++;
        }

        return ans.toString();

    }  
}
