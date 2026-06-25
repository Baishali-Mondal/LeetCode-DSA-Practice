// TC - O(n)
// SC - O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pref = 1;
        int suff = 1;
        int result = Integer.MIN_VALUE;

        for( int i=0; i<=n-1; i++ ){
            if(pref == 0) pref = 1; // avoiding '0' wala nums[]
            if(suff == 0) suff = 1;

            pref = pref * nums[i];
            suff = suff * nums[n-i-1];

            result = Math.max(result, Math.max(pref, suff));
        }
        return result;
    }
}