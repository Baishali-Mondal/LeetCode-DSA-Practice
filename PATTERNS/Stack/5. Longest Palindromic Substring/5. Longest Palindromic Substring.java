// TC - O(n²)
// SC - O(1)

class Solution {
    public int expandPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0){
            return "";
        }

        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++){
            int odd = expandPalindrome(s, i, i); //odd length palindrome
            int even =  expandPalindrome(s, i, i+1); //even length palindrome

            int maxLen = Math.max(even, odd);

            if(maxLen > end - start){
                start = i-(maxLen-1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end+1);
    }
}