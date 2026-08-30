// TC - O(m+n)
// SC - O(26)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        return false;

        int count[] = new int[26];

        for(int i=0; i<s.length(); i++)
        {
            count[s.charAt(i)-'a']++;
        }

        for(int i=0; i<t.length(); i++)
        {
            if(count[t.charAt(i)-'a'] == 0) // t has extra characters or it more than that in s
            return false;

            count[t.charAt(i)-'a']--;
        }
        return true;
    }
}
