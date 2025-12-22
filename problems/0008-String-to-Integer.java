// ===   Question:   ===
// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

// The algorithm for myAtoi(string s) is as follows:
// [1] Whitespace: Ignore any leading whitespace (" ").
// [2] Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
// [3] Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// [4] Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
// Return the integer as the final result.



// ===   Solutions:   ===
class Solution {
    public int myAtoi(String s) {

        // Get the length of the string
        int n = s.length();

        // Set the index position for valid digits, initialized at position 0
        int index = 0;

        // Store the final result
        int res = 0;

        // According to [1] Whitespace: Ignore any leading whitespace (" ").
        while (index < n && s.charAt(index) == ' ' ) {
            // Move the index position forward
            index ++;
        };

        // According to [2] If no digits were read, then the result is 0.
        if (index == n){
            return 0;
        }

        // According to [3] Determine the sign
        boolean negative = false;
        if (s.charAt(index) == '-'){
            negative = true;
        }
        // Need to skip the sign character
        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            index++;
        }

        // Start reading the digits
        while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            int lastNum = s.charAt(index) - 48;

            // According to "Rounding"
            if (!negative && (res > 214748364 || (res == 214748364 && (lastNum == 8 || lastNum == 9))) ){
                return 2147483647;
            } 

            if (negative && (-res < -214748364 || (-res == -214748364 && (lastNum==8 || lastNum==9)))){
                return -2147483648;
            }

            res = res * 10 + lastNum;
            index ++;
        }
        return negative? -res: res;
    }
}
