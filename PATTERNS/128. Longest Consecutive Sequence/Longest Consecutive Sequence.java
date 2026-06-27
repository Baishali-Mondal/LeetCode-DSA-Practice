// //OPTIMAL - USING SET DS
// TC - O(N)
// SC - O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if( n == 0 ) return 0;
        HashSet<Integer> set = new HashSet<>();
        for( int i=0; i<n; i++){ //O(N)
            set.add(nums[i]);
        }
        int maxLen = 0;

        for( int ele : set){ // O(N)+O(N) -> O(2N)
            if(!set.contains(ele-1)){ //ignoring if previus doesn't exist
                int len = 1;
                int nextEle = ele+1;
                while(set.contains(nextEle)){ //due to ignorance, will run near about O(n)
                    len = len+1;
                    nextEle = nextEle+1;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}


// BETTER - SORTING THE NUMS AND SEARCHING FOR NEXT ELEMENT AND SKIPPING THE DUPLICATES
// TC - O(NlogN)+O(N)
// SC - O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if( n == 0 ) return 0;
        Arrays.sort(nums);  //(NlogN)
        int maxLen = 1;
        int len = 1;
        int prev = nums[0];

        for( int i=1; i<n; i++){ // O(N)
            if( prev == nums[i] ){
                continue;
            }else if( nums[i] == (prev+1)){
                len = len+1;
                // prev = nums[i];
            }else{
                len = 1;
                // prev = nums[i];
            }
            prev = nums[i];
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}


// BRUTE - doing a linear search while searching for the next element
// TC - O(n^3)
// SC - O(1)
class Solution {
    boolean lSearch(int[] nums, int element){ //O(n)
        for(int i=0; i<nums.length; i++){
            if(nums[i] == element){
                return true;
            }
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int currEle, nextEle;

        if(n == 0) return 0;
        for( int i=0; i<n; i++ ){ //O(n)
            currEle = nums[i];
            nextEle = currEle+1;
            int len = 1;
            while(lSearch(nums, nextEle)){ // linear search-O(n) and while loop-O(n)
                len = len+1;
                nextEle = nextEle+1;
            }
            maxLen = Math.max(len, maxLen);
        }  
        return maxLen;      
    }
}