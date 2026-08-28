//TC - O(n)
// SC - O(n)
class Solution {
    public int[] buildArray(int[] nums) {
        int size = nums.length;
        int res[] = new int[size]; // SC->O(n)
        for(int i=0; i<size; i++) 
        {
            res[i] = nums[nums[i]];
        }       
        return res;
    }
}
