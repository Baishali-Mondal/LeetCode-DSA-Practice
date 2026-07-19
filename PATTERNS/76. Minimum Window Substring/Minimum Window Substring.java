class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        
        if(t.length() > n){ // If t is longer than s then t can't fit in s
            return "";
        }

       Map<Character, Integer> mp = new HashMap<>(); // to store the count of characters

        //to store the count of characters in the string 't'
        for(char ch : t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        int reqCount = t.length(); 

        //Sliding Window starts
        int i=0; int j=0;
        int start_i = 0;
        int minWindowSize = Integer.MAX_VALUE;

        while(j < n){
            char ch = s.charAt(j);     

            //If character present in map and value>0 means we need that character
            if(mp.containsKey(ch) && mp.get(ch)> 0){
                reqCount--;  //hence decrement the count and decrement the value in map
            }
            //even decrement the value in the map of char present as well for those not present
            mp.put(ch, mp.getOrDefault(ch, 0)-1);

            // reqCount=0 means now we need to find the window of minimum size
            while(reqCount == 0){
                //Shrink Window 
                int currWindowSize = j-i+1;

                if(currWindowSize < minWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = i; //store ith index to get keep a track to return window size
                } 

                // while shrinking increment the char value in map
                char removeChar = s.charAt(i);
                mp.put(removeChar, mp.getOrDefault(removeChar, 0)+1);
                
                // Removed character has value > 0 means it is the part of the T string
                // Need to increment the reqCount in hope of finding a better window
                if(mp.containsKey(removeChar) && mp.get(removeChar)>0){
                    reqCount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : 
                        s.substring(start_i, start_i + minWindowSize);
    }
}