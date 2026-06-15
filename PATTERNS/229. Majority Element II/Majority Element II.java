// USING HASHMAP
// TC-->O(n) 
// SC-->O(n)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int major = (nums.length/3)+1; // Keeps the track of the frequency for which the  
                                        //element with the specified freq only need to be added in the ArrayList

        for( int num : nums ){
            mp.put(num, mp.getOrDefault(num,0)+1 );  //checks if element exist then update or add new to the map
            if( mp.get(num) == major ){ //Element having freq(n/3 +1) then only add to the ArrayList else ignore
                list.add(num);
            }
            if( list.size() == 2 ){ // floor(n/3) can have atmost 2 elements and not more
                break;
            }
        }
        return list;
    }
}



//<----** BOYER MOORE VOTING ALGO (SELECT A LIST OF CANDIDATE AND VOTE FOR/AGAINST IT)
// N/3--> CAN ATMOST HAVE 2 MAJOR ELEMENTS (i.e N/K CAN HAVE ATMOST (K-1) MAJOR ELEMENTS)
// TC --> O(n)+O(n)+O(1) = O(n)
// SC --> O(1) **--->

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int cnt1 = 0;
	int cnt2 = 0;
        int major1 = -1; 
	int major2 = -1;
        int n =  nums.length;

	//since the array can have at max 2 major elements so maj1 and maj2 ie choose a majority and increment 	//the count, if that nums[i] exists then just increment, and if encounter a different element look for   	//any count=0 and then assign that as majority and increment else neither of 2 major in the nums[i] 	//decrement the count 

        for( int i=0; i<n; i++ ){ // O(n)
            if( major1 == nums[i] ){
                cnt1++;
            }else if( major2 == nums[i] ){
                cnt2++;
            }else if( cnt1 == 0 ){
                cnt1 = 1;
                major1 = nums[i];
            }else if( cnt2 == 0 ){
                cnt2 = 1;
                major2 = nums[i];
            }else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> result = new ArrayList<>();

        int freq1 = 0;
        int freq2 = 0;
        for(int num : nums){ //O(n)
            if( major1 == num ){
                freq1++;
            }else if( major2 == num ){
                freq2++;
            }
        }
	//adding those major elements in the arraylist with the required freq
        if( freq1 > (n/3)){
            result.add(major1); //O(1) 
        }
        if( freq2> (n/3) ){
            result.add(major2);
        }
        return result;
    }
}