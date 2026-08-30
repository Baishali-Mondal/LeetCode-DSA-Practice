
//TC - O(n) && SC - O(1)
class Solution {
    public boolean isPalindrome(String s) {
              
        // s = s.replaceAll("[^a-zA-Z0-9]",""); //removes all non alphanumeric
        int start = 0;
        int end = s.length()-1;
        while(start < end) // Outer loop controls overall palindrome checking
        {
            while(start < end && !Character.isLetterOrDigit(s.charAt(start)))
            {start++;}
            while(start < end && !Character.isLetterOrDigit(s.charAt(end)))
            {end--;} //Inner loop conditions prevent pointers from going out    of bounds while skipping invalid characters  for cases like s = ".,"
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end)))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;        
    }
}