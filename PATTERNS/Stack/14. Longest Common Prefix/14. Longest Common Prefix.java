// TC - O(S) --> 'S' is the total no of characters in the str[]
// SC - O(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0]; //Storing the first str ie str[0] into the prefix

        for(int i=1; i<strs.length; i++){
            while(!strs[i].startsWith(prefix)){  // verifying for every substring prefix for the next str[i]
                prefix = prefix.substring(0, prefix.length()-1);

                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}