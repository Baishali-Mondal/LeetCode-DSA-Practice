// TC - O(nlogn)+O(nlogn)+O(nlogn) == O(nlogn)
// SC - O(1)
class Solution {

    public int binarySearch(int[] nums, int start, int end, int target){
        int n = nums.length;

        //normal Binary Search
        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
        }
        return -1;
    }

    public int findMinNum(int[] nums){
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int next = (mid+1) % n;
            int prev = (mid+n-1) % n;

            //prev < target < next is the point of rotation in the sorted array
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]){
                return mid;
            }

            else if(nums[mid] <= nums[end]){ // right half is sorted so look for in the left half
                end = mid-1;
            }

            else if(nums[start] <= nums[mid]){ // left half is sorted so look for in the right half
                start = mid+1;
            }
        }
        return 0;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        //Finding the rotation point
        int minIndex = findMinNum(nums); //O(nlogn)

        // partitioning the nums into two halves 
        // approx O(nlogn)+O(nlogn)for two halves
        int firstSegment = binarySearch(nums, 0, minIndex-1, target); //finding in the left sorted array
        int secondSegment = binarySearch(nums, minIndex, n-1, target);//finding in the right sorted array

        //either of them will either return the index of element if present & -1 if not present
        if(firstSegment != -1){ 
            return firstSegment;
        }
        return secondSegment;
    }
}