// ===   Questions   ===:
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// ===   Solutions ===:

class Solution {
    public double myPow(double x, int n) {
        
        // Any number to the power of 0 equals 1. Since the problem requires returning double type, return 1.0
        if (n== 0) return 1.0;

        // Case 1: If n is even
        if ((n & 1)==0){
            return myPow(x * x, n / 2);

        // Case 2: If n is odd
        } else {

            // Case 2.1: n is positive
            if (n>0) return myPow(x*x,n/2) * x;
            if (n < 0) return myPow(x*x, n/2) * 1/x;

            // Case 2.2: n is negative
        }
        return -1;
    }

}
