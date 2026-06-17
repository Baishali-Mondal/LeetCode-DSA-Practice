//TWO POINTER
//Time Complexity = O(n)
//Space Complexity = O(1)
class Solution {
    public int trap(int[] height) {
        int trapWater = 0;
        int n = height.length;
        int left = 0, right =n-1;
        int lMax=0, rMax=0;

        while (left < right){
            //left height is smaller than right height
            //water level is already determined by the smaller side.
            if(height[left] < height[right]){
                //assigning the lMax with maximum height
                if(height[left] > lMax){
                    lMax = height[left];
                }else{
                    trapWater += lMax -height[left];
                }
                left++;
            }
            else{
                //right height is smaller than left height
                if(height[right] > rMax){
                    rMax = height[right];
                }else{
                    trapWater += rMax - height[right];
                }
                right--;
            }
        }
        return trapWater;
    }
}


// USING TWO ARRAY TO STORE THE LEFT MAX AND RIGHT MAX
//Time Complexity = O(3n) ==O(n)
//Space Complexity = O(2n)
class Solution {
    public int trap(int[] height) {

        int trapWater = 0;
        int n = height.length;

        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = height[0];
        rMax[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }
        for( int i=n-2; i>=0; i--){
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }
        for(int i=0; i<n; i++){
        trapWater = trapWater + (Math.min(rMax[i],lMax[i]) - height[i]);
        }
        return trapWater;        
    }
}