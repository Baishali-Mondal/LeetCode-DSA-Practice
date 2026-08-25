// BACKTRACKING
// TC - O(n*n!)
// SC - O(n)

class Solution {

    void solve(int[] nums, boolean[] used, List<Integer> ds, List<List<Integer>> res){

        if(ds.size() == nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        //Try every element
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            //PICK
            used[i] = true;
            ds.add(nums[i]);

            //EXPLORE
            solve(nums, used, ds, res);

            //BACKTRACK
            ds.remove(ds.size()-1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[n];

        solve(nums, used, new ArrayList<>(), res);

        return res;
    }
}