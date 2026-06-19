//KADANE'S ALGORITHM
// Time Complexity - O(n)
// Space Complexity - O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currSum = 0;

        for(int i=0; i<n; i++){
            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);

            if(currSum < 0){ //no use of keeping the -ve as it decrease the currSum so reset
                currSum = 0;
            }
        }
        return maxSum;
    }
}


// BRUTE -- USING TWO LOOPS
// Time Complexity - O(n^2)
// Space Complexity - O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0]; 

        for( int st=0; st<n; st++ ){
            int currSum = 0;
            for(int end=st; end<n; end++ ){
                currSum += nums[end];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}