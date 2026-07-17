// //Approach3 -SLIDING WINDOW
// // TC - O(n+m)
// //SC - O(26)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        //length of s1 is larger so it won't fit in s2
        if(n > m ) return false;

        int[] s1Freq = new int[26]; //freq for s1
        int[] s2Freq = new int[26]; // freq for current window of s2

        for(int i=0; i < n; i++){  //O(n)
            s1Freq[s1.charAt(i)-'a']++; //store the frequencies if s1 
        }

        // Slide window over s2 of size n
        int start = 0;
        int end = 0;

        while(end < m){ //O(m)
            s2Freq[s2.charAt(end)-'a']++;//Store freq of current window

            //if window exceeds reduce the freq
            if(end-start+1 > n){
                s2Freq[s2.charAt(start)-'a']--;
                //shrink the window
                start ++;
            }

            if(Arrays.equals(s1Freq, s2Freq)){ //check for equal strings
                return true;
            }
            end++;//increase the window
        }
        return false;
    }
}

//Approach2 - SORTING & COMPARING
// TC - O((m-n) * nlogn)
// SC - O(n)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        //length of s1 is larger so it won't fit in s2
        if(n > m ) return false;

        //Sort string s1
        char[] sorteds1 = s1.toCharArray(); //O(n)
        Arrays.sort(sorteds1); //O(nlogn)

        for(int i=0; i<=m-n; i++){ //O(m-n)

            // Extract a substring of lenth n in s2
            String tempSubStr = s2.substring(i, i+n);

            //sort the substring
            char[] sortedTemp = tempSubStr.toCharArray();//O(n)
            Arrays.sort(sortedTemp); //O(nlogn)

            if(Arrays.equals(sortedTemp, sorteds1)){ //Compare both the strings
                return true;
            }
        }
        return false;
    }
}

// Brute : TLE
//T.C : O(n! * m)
//S.C : O(n)

class Solution {
    private int n;
    private boolean result;

    //Backtracking method to genrate permutation of s1
    private void solve(int idx, String s1, String s2){
        if(idx == n){
            if(s2.contains(s1)){// check if permutation of s1 is present in s2
            result = true;
            }
            return;
        }

        //Generate all permutations of s1
        char[] charArr = s1.toCharArray();// convert string to char array for swaping
        for(int i=idx; i<n; i++){
            
            swap(charArr, idx, i);
            String newS1 = new String(charArr);// convert char array to string

            solve(idx+1, newS1, s2);

            swap(charArr, idx, i);

            if(result){//early exit if permutation is found
                return;
            }
        }
    }
        private void swap(char[] arr, int i, int j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


    public boolean checkInclusion(String s1, String s2) {
        n = s1.length();
        result = false; //reset result for each call

        //start backtracking process
        solve(0, s1, s2);

        return result; // if permutation of s1 is present in s2
    }
}