// ========== Question ============
// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

// Solution: Greedy algorithm 

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 1. If current position already has a flower, the next position clearly cannot have a flower, so we can skip it
        // 2. If current position doesn't have a flower, need to consider if we can plant a flower here
        for (int i = 0; i < flowerbed.length && n > 0; ){
            if (flowerbed[i] == 1){
                i+=2;

            // 2. This means current position doesn't have a flower: flowerbed[i] == 0
            // 3. If this position is the last position of the array, the next position doesn't exist,
            //    there's no restriction, so we can plant a flower at flowerbed[i]
            // 4. If this position is NOT the last position of the array, only when the next position 
            //    doesn't have a flower can we plant a flower at flowerbed[i]
            } else if (i == flowerbed.length - 1 || flowerbed[i+1] == 0) {
                n--;
                i+=2;
            } else {
                // i + 1 already has a flower, no need to check it again
                // i + 2 position cannot have a flower either since i+1 has a flower
                i+=3;
            }
            
        }
        // Finally check if we have planted all n flowers
        return n <= 0;
    }
}
