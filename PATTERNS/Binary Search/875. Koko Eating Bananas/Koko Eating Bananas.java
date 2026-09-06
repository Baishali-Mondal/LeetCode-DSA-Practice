class Solution {
    public boolean canEat(int[] piles, int h, int k){
        long hours = 0;

        for(int pile : piles){
            hours += (long) Math.ceil((double)pile/k);
        }

        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        //Finding the max pile
        for(int pile : piles){
            high = Math.max(high, pile);
        }

        int res = high;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(canEat(piles, h, mid)){
                res = mid;
                high = mid - 1; //Try smaller speed
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}

// Time Complexity : O(n log M) --> n = piles.length and M = max(piles)
// Space Complexity : O(1)