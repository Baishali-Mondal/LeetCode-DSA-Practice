//USING RECURSION
// Time Complexity: O(2^n) — every element has 2 choices(pick or not pick).
// Auxiliary Space: O(n)

class Solution {
    static boolean solve(int[] arr, int target, int ind){
        
        //BASE CASE
        if(target == 0){
            return true;
        }
        
	// index goes out of bound
	// if the sum is negative no use of picking an going further
        if(ind == arr.length || target < 0){ 
            return false;
        }
                //PICK or //NOT PICK
        return solve(arr, target-arr[ind], ind+1) || solve(arr, target, ind+1);
    }

    static boolean isSubsetSum(int arr[], int sum) {

        return solve(arr, sum, 0);
    }
}
