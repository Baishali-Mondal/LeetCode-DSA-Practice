// BackTracking & Recursion (Subset + Sorting + Duplicate skipping)
// TC - O(n * 2^n)
// SC - O(n) (Ausxilliary Space)

class Solution {

    void solveSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> res){

        //Every node of the recursion tree is a valid subset
        res.add(new ArrayList<>(ds));

        for(int i=ind; i<nums.length; i++){
            // skip duplicate choices at the same level
            if(i > ind && nums[i] == nums[i-1]){
                continue;
            }

            //Pick
            ds.add(nums[i]);

            solveSubsets(i+1, nums, ds, res);

            //BackTrack
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        
        solveSubsets(0, nums, new ArrayList<>(), res);

        return res;
    }
}