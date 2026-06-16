//BRUTE 
// TC->O(n³) SC->O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp); //to avoid duplicate list of elements
                        set.add(temp);
                    }
                }
            }
        }
        // List<List<Integer>> res = new ArrayList<>();
        // res.addAll(set);
        // return res;
        return new ArrayList<>(set);
    }
}

//OPTIMAL - USING TWO - POINTER
// TC-O(n^2) 
// SC-O(1)
class Solution {

    void twoSum(int[] nums, int i, int target, List<List<Integer>> result){
        int j = nums.length-1;

        while(i < j){ //untill i doesn't cross j
            if(nums[i] + nums[j] > target){
                j--;
            }else if(nums[i] + nums[j] < target){
                i++;
            }else{

                result.add(Arrays.asList(-target, nums[i], nums[j])); //storing the result
                while(i < j && nums[i] == nums[i+1]){ //if the consecutive have same elements
                    i++;
                }
                while(i < j && nums[j] == nums[j-1]){//if the consecutive have same elements
                    j--;
                }
                i++;
                j--;
            }
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if(n < 3) { //array having less than 3 elements would be of no use
            return new ArrayList<>();
        }
        Arrays.sort(nums); //Sorting to avoid the duplicates

        for(int i=0; i<n-2; i++){ //running the loop till the third last element as we can 
                                    //find 3 elements till there only
            if(i!=0 && nums[i] == nums[i-1]){//to avoid the duplicate results
                continue;
            }
            int target = -nums[i]; // fixing n1 as n1+n2+n3 = 0 => n2+n3 = -(n1)
            twoSum(nums, i+1, target, result ); // finding the n2 & n3 :{n1, n2, n3}
        }
        return result;
    }
}