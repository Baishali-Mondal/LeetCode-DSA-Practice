class Solution {
    
    boolean solve(int ind, String s, Set<String> dict){
        //Entire string has been successfully partioned 
        if(ind == s.length()){
            return true;
        }
        
        //Trying all possible substring
        for(int i= ind; i<s.length(); i++){
            
            String word = s.substring(ind, i+1);
            
            //Constraints : word must exist in the dictionary
            if(dict.contains(word)){
                
                //PICK
                if(solve(i+1, s, dict)){
                    return true;
                }
                
                //If recursion returns false we automatically backtrack
            }
        }
         return false;//no possible word worked from this index ie no valid partition from this index
    }
    
    public boolean wordBreak(String s, String[] dictionary) {
        
        Set<String> dict = new HashSet<>();
        
        for(String word : dictionary){
            dict.add(word);
        }
        
        return solve(0, s, dict);
    }
}