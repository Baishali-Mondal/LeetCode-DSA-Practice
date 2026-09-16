// TC - O(n)
// SC - O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){ //remove the less warmer temp
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = 0;
            }
           else if(!st.isEmpty()){ //if stack is not empty then top is the next warmer element
               ans[i] = st.peek() - i; 
            }
            st.push(i);
        }
        return ans;
    }
}