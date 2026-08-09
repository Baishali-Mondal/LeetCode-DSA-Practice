//SORTING & FILTERING(TO AVOID DUPLICATES) + BACKTRACKING
//TC - O(2^n)
//SC - O(n)

class Solution {

    void solveCombinationSum(int ind, int[] nums, int target, List<Integer> ds, List<List<Integer>> res){

        // found the combination with the specified target
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<nums.length; i++){
            
            //skip duplicate choices at the same level 
            if(i>ind && nums[i] == nums[i-1]){
                continue;
            }

            //since nums is sorted & if any particular element > target futher going is of no use
            if(nums[i] > target){
                break;
            }

            //Pick
            ds.add(nums[i]);

            //i+1 as each elemnt can be used once
            solveCombinationSum(i+1, nums, target-nums[i], ds, res); 

            //Backtrack
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates); // to bring same elements together to avoid duplicate combinations

        List<List<Integer>> res = new ArrayList<>();

        solveCombinationSum(0, candidates, target, new ArrayList<>(), res);

        return res;
    }
}