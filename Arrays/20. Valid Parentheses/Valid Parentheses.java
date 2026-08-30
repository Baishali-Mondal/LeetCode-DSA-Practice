// TC - O(n)
// SC - O(n)
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch== '{' || ch == '[' )
            { 
                st.push(ch); //storing all the opening braces into the stack
            }
            else 
            {
                if(st.isEmpty())
                return false;
            
                char top = st.pop();

                if( (ch==')' && top!='(') || (ch=='}' && top!='{') || (ch==']' && top!='['))
                {
                    return false;  //returns true will be wrong because it will return true in the first match and it never looks for the rest of the string which is wrong
                }
            }
        }
        return st.isEmpty();
    }
}