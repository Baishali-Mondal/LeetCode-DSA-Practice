//OPTIMAL - IN PLACE
// TC-O(N)
//SC-O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;

        if( n == 0){
            return 0;
        }

        for(int j=1; j<n; j++){ 
            if(nums[i-1] != nums[j]){
                nums[i] = nums[j];
                i++; 
            }
        }
        return i;
    }
}

//BRUTE - USING EXTRA TEMP NOT IN PLACE
// TC-O(N)
//SC-O(N)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 1;

        int temp[] = new int[n]; //using extra space
        temp[0] = nums[0];

        for(int i=1; i<n; i++){
            if( temp[j-1] != nums[i]){
                temp[j] = nums[i];
                j++;
            }
        }
        for(int i=0; i<j; i++){ //overwriting the nums[]
            nums[i] = temp[i];
        }
        return j;
    }
}