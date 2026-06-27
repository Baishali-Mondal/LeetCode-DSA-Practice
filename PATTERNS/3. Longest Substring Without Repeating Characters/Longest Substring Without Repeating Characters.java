// TC - O(N) - each character is processed once
// SC - O(min(N,256)) near about O-(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;

        while(end < n){
            char ch = s.charAt(end);
            if(map .containsKey(ch) && map.get(ch)>=start){
                start = map.get(ch) + 1;
            }
            map.put(ch, end);
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }
}

// TC - O(N) nearabout 2N as while window shrinking it's deleting 1 element at a time and N for as each character is processed once for the hashset
// SC - O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int winStr = 0;
        int winEnd = 0;

        HashSet<Character> set = new HashSet<>();
        int len = 0;
        int maxLen = 0;
        while(winEnd < n){
            char ch = s.charAt(winEnd);
            if( set.contains(ch) ){
                while( winStr < winEnd && set.contains(ch) ){
                    set.remove(s.charAt(winStr));
                    winStr++;
                }
            }
            set.add(ch);
            len = winEnd - winStr + 1;
            maxLen = Math.max( maxLen, len );
            winEnd++;
        }
        return maxLen;
    }
}