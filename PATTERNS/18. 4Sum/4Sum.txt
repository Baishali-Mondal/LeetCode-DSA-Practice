//Time Complexity = O(n³)
//Space Complexity = O(1)
class Solution {
    int num1, num2;
    void twoSum(int[] nums, int idx, List<List<Integer>> result, long target){
        int i =idx;
        int j = nums.length-1;

        while(i < j){
            long sum = nums[i] + nums[j];
            if(sum > target){
                j--;
            }else if(sum < target){
                i++;
            }else{
                while(i < j && nums[i] == nums[i+1]){
                    i++;
                }
                while( i < j && nums[j] == nums[j-1]){
                    j--;
                }
                result.add(Arrays.asList(num1, num2, nums[i], nums[j]));
                i++;
                j--;
            }
        }
    }
    void threeSum(int nums[], int idx, List<List<Integer>> result, long target){
        for(int i=idx; i<nums.length-2; i++){
            if(i>idx && nums[i] == nums[i-1]){
                continue;
            }
            num2 = nums[i];
            twoSum(nums, i+1, result, target-nums[i]);
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if(n < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        
        for(int i=0; i < n-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            num1 = nums[i];
            threeSum(nums, i+1, result, target - nums[i]);
        }
        return result;
    }
}

//Time Complexity = O(n³)
//Space Complexity = O(1)
class Solution {
    int num1, num2;
    void twoSum(int[] nums, int i, int j, List<List<Integer>> result, long target){
        int start = j+1;
        int end = nums.length-1;

        while(start < end){
            long sum = nums[start] + nums[end];
            if(sum > target){
                end--;
            }else if(sum < target){
                start++;
            }else{
                result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                while(start < end && nums[start] == nums[start+1]){
                    start++;
                }
                while( start < end  && nums[end] == nums[end-1]){
                    end--;
                }
                
                start++;
                end--;
            }
        }
    }
   
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if(n < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        
        for(int i=0; i < n-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                long subTarget =(long) target-(nums[i] + nums[j]);//avoid integer overflow for certain testcase
                twoSum(nums, i, j, result, subTarget);
            }
        }
        return result;
    }
}