// TC  = O(log(min(n, m)))
// SC = O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1); //call median on shorter array to meet the TC
        }

        int low = 0;
        int high = n1;
        int total = n1 + n2;

        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = ((total + 1) / 2) - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];

            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if(total % 2 == 1){
                    return Math.max(l1, l2); // when the combined no of elements are odd
                }
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0; // combined elements are even
            }

            else if(l1 > r2){ // too many elements picked from nums1 need to reduce
                high = mid1 - 1;
            }

            else{ // too few elements picked from nums1 need to increment
                low = mid1 + 1;
            }
        }
        return -1;
    }
}