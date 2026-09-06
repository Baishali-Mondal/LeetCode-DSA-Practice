// TC - O(nlogn)
// SC - O(1)
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        if(nums[start] < nums[end]){ //edge case if array is not rotated
            return nums[0];
        }
        while(start <= end){
            int mid = start + (end-start)/2;

            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
		
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]){ //nums[index] of rotated array
		//get the pivot of rotation 
                return nums[mid];
            }
            else if(nums[mid] <= nums[end]){ // right half is sorted as per sequence move to left half
                end = mid-1;
            }
            else if(nums[start] <= nums[mid]){ 
                start = mid+1;
            }
        }
        return -1;
    }
}