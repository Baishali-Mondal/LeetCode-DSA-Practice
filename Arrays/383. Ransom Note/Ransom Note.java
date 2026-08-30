
// TC - O(m+n)
// SC - O(26)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int freq[] = new int[26];
        for(int i=0; i<magazine.length(); i++)
        {freq[magazine.charAt(i)-'a']++;}

        for( int i=0; i<ransomNote.length(); i++) //Consuming letters of ransomnote and comparing
        {
            char ch=ransomNote.charAt(i);
            if(freq[ch-'a'] == 0) //while checking freq = 0 means all letters of mag are exhausted
            return false;

            freq[ch-'a']--;
        }
        return true;
    }
}