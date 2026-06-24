// BRUTE FORCE - outer loop run from 1st element to 2nd last element and 2nd loop runs from (i+1) th element to last element
// Time Complexity = O(n²)
// Space Complexity = O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for( int i=0; i<nums.length; i++){
            for( int j=i+1; j<nums.length; j++){
                if(target - nums[j] == nums[i] ){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}


// //OPTIMIZED APPROACH -- USING HASHMAP
// Time Complexity = O(N)+[O(1) for hashmap operation] ==> O(N)
// Space Complexity = O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int rem = target - nums[i];
            if(mp.containsKey(rem))
            {
                return new int[]{mp.get(rem),i};
            }
            mp.put(nums[i], i);
        }
        return new int[]{};
    }
}

