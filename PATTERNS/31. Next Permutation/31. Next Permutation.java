// TC - O(3N)
// SC - O(1) in place
class Solution {
    void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        // Find the break point
        int n = nums.length;
        int ind = -1;
        for(int i = n-2; i>=0; i--){ //comparing the last two element so starting from n-2
            if( nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }
        // Find >break_point_element but the smallest one
        if(ind != -1){
        for(int i=n-1; i>=ind; i--){
            if( nums[i] > nums[ind] ){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        }
        // sort the remaining by using the reverse
        reverse(nums, ind+1, n-1);
    }
}