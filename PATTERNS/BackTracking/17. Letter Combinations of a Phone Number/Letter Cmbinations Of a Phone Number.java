// TC - O(4^n * n)
// SC - O(n)
class Solution {

    void solve(int ind, String digits, StringBuilder ds, List<String> res, String[] map){
        //All digits have been processed
        if(ind == digits.length()){
            res.add(ds.toString());
            return;
        }

        //Get the letters corresponding to current digit
        String letters = map[digits.charAt(ind) - '0'];

        //Try every possibility
        for(int i=0; i<letters.length(); i++){

            //PICK
            ds.append(letters.charAt(i));

            //EXPLORE
            solve(ind+1, digits, ds, res, map);

            //BACKTRACK
            ds.deleteCharAt(ds.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0){
            return res;
        }

        String[] map = {
            "", //0
            "", //1
            "abc", //2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //7
            "tuv", //8
            "wxyz", //9
        };

        solve(0, digits, new StringBuilder(), res, map);

        return res;
    }
}