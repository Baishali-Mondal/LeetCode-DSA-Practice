//OPTIMAL - USING DUTCH NATIONAL FLAG ALGO
//Time Complexity = O(n) -->Single Traversal
// Space Complexity = O(1)

class Solution {
    public void sortColors(int[] nums) {
        int i = 0;  //i is reponible for storing 0
        int j=0;    //j is reponible for storing 1
        int k = nums.length-1;  //k is reponible for storing 2

        while( j <= k ){
            if(nums[j] == 1){
                j++;
            }else if(nums[j] == 2){
                //swap to put 2 on extreme right side
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;

                k--;
            }else { //nums[j] == 0
                //swap to put 0 on extreme left side
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++; j++;
            }
        }
    }
}

//BRUTE
//Time Complexity = O(2n) == O(n)  -->Two traversal
// Space Complexity = O(1)

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int cnt0=0; int cnt1=0; int cnt2=0;

        for( int i = 0; i < n; i++ ){
            if(nums[i] == 0){
                cnt0++;
            }else if( nums[i] == 1 ){
                cnt1++;
            }else{
                cnt2++;
            }
        }
        for(int i=0; i<cnt0; i++){
            nums[i] = 0;
        }
        for( int i=cnt0; i<cnt0+cnt1; i++){
            nums[i] = 1;
        }
        for( int i = cnt0+cnt1; i<n; i++ ){
            nums[i] = 2;
        }
    }
}