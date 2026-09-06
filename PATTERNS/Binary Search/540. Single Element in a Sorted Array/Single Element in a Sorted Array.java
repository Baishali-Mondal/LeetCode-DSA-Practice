// TC - O(nlogn)
// SC - O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start < end){
            int mid = start + (end-start)/2;

            //make mif even
            if(mid % 2 == 1){ //if mid index !even shift mid-- as a pair will definetly exist at next odd
                mid--;
            }

            // index  -> 0 1 2 3 4 5 6 7 8  // index  -> 0 1 2 3 4 5 6 7 8
            // nums[] -> 1 1 2 3 3 4 4 8 8  // nums[] -> 1 1 2 2 3 3 4 4 8  //all pair starts at even idx
            // check for no at even idx == next odd idx --> until this mid all are in pairs
            // Correct pair : (even,odd)

            if(nums[mid] == nums[mid+1]){
                //until mid all are in pairs, hence look for single elemnt into right half

                start = mid+2;
            }
            else{ //pair is broken -> look for the ele in the first half itself or it might be mid
                end = mid;
            }
        }            
        return nums[start];  
    }
}