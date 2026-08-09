// RECURSION + BACKTRACKING
//Time Complexity - exponential as same element can pe picked numerous times -> approx O(n^T/m) (T-target, m = min candidate value that is picked numerous times)

//Space Complexity - Unpredictable but it depends on the no of combinations formed


class Solution {

    void solve(int ind, int[] nums, int target, List<Integer> ds, List<List<Integer>> result){

        //Base Case
        // found the set that is equal to the target
        if(target == 0){
            result.add(new ArrayList<>(ds));
            return;
        }
        //index has crossed the length of the array or the when the target becomes -ve
        if(ind == nums.length || target < 0){
            return;
        }


        //Pick
        if(nums[ind] <= target){
            ds.add(nums[ind]); // add the index value to ds list

            solve(ind, nums, target-nums[ind], ds, result);

            ds.remove(ds.size()-1); //remove the last inserted element -> then move to not pick case
        }

        //Not Pick
        solve(ind+1, nums, target, ds, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), result);

        return result;
    }
}