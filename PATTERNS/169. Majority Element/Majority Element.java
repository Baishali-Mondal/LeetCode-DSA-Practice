// //USING MAP  --> TC-O(N) || SC-O(N)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

//        //Storing the value in the map
//        for(int i=0; i<n; i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i], map.get(nums[i])+1);
//            }
//            else{
//                map.put(nums[i],1);
//            }
//        }
//
//        //Map Traverse
//        for(int key : map.keySet()){ //keyset() method returns all the key contained within a map
//            if(map.get(key) > n/2)
//            return key;
//        }
        //Storing the frequency as well look for a freq > n/2
        for(int num :nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
            if(map.get(num) > n/2){
                return num;
            }
        }
        return -1;
    }
}

//// OPTIMIZED - USING BOYER MOORE VOTING ALGO (Choose a candidate and vote for/against it)  
//--> TC-O(N) SC-O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorElement = -1;
        int n = nums.length;

        for( int i=0; i<n; i++){
            if( majorElement == nums[i]){  //if majority exist the increment the count
                count++;
            }else if( count == 0 ){     // choosing a majority and incrementing the count to 1
                count = 1;
                majorElement = nums[i];
            }else{               // if the major element and the nums[i] are different then decrement the count
                count--;
            }
        }
        return majorElement;
    }
}