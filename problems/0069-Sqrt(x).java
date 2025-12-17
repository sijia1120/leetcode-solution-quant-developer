// ===   Question   ===
// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.


// ===   Solution   ===
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        int ans = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            // Since the range of x can reach the maximum value of int,
            // mid could also be very large, causing mid * mid to exceed the int range, so we use long

            if ( (long)mid * mid <= x){
                ans = mid;

                // Move left boundary to the right, discard all elements on the left
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return ans;
        
    }
}
