// OPTIMAL - HARE & TORTOISE
// TC - O(n)
// SC - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        //DETECT THE CYCLE OR THE DUPLICATE
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while( slow != fast);

        //RESET pointers
        fast = nums[0];
        while( slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}


// APPROACH 2 - USING HASHSET
// TC - O(n)
// SC - O(N)
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}

// BRUTE - COUNT THE NO OF APPERANCE OF EACH ELEMENT
// TC - O(n*n)
// SC - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
                if(cnt > 1){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}