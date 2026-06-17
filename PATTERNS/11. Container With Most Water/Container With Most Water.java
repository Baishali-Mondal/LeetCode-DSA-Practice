class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int currArea = 0, maxArea = 0;

        while( left < right ){
            // currArea = width * height
            //width = difference of indexes
            //height = min height to avoid the overflow of water

            currArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currArea);

            //as we are decreasing the width we need to retain the max height to maximize o/p
            if(height[left] < height[right]){ 
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}