// BACKTRACKING (FIRST CHECK IF A STRING IS PALINDROME IF YES THEN ONLY PROCESS FURTHER)
//TC - O(2^n * n) n-for substring and palindrome checking
//SC - O(n) (Stack Space)

class Solution {

    void solvePalindromePartition(int ind, String s, List<String> ds, List<List<String>> res){

        //partitioned the entire string
        if(ind == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<s.length(); i++){

            //only check if a particular substring is palindrome
            if(isPalindrome(s, ind, i)){
                
                //Pick the substring which was checked earlier
                ds.add(s.substring(ind, i+1));  //Java's substring(start, end) takes end as exclusive

                solvePalindromePartition(i+1, s, ds, res); 

                ds.remove(ds.size()-1);               
            }
        }
    }

    boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
            return false;

            left ++;
            right--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        solvePalindromePartition(0, s, new ArrayList<>(), res);

        return res;
    }
}