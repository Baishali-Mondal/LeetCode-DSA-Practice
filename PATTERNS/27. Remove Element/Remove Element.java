//TWO POINTER 
//Time Complexity - O(n) 
// Space Complexity - O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int idx = 0;

        for(int i=0; i<n; i++){
            if( nums[i] != val ){ //if value doesn't match  replace and increment
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}