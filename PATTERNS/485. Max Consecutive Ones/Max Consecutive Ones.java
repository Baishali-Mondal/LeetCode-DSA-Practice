// TC - O(n)
// SC - O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int result=0;
        int count = 0;

        for( int i=0; i<n; i++ ){
            if(nums[i] == 1){
                count++;
            }else if( nums[i] == 0 ){
                result = Math.max( count, result);
                count = 0;
            }
        }
        result = Math.max( count, result );
        return result;
    }
}