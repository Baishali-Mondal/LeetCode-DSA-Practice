// TC - O(4n)
// SC - O(4n)

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        // Find the previous smaller element
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = st.peek();
            }
            st.push(i);
        }
        
        st.clear();
        
        // Find the previous smaller element
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = st.peek();
            }
            st.push(i);
        }
        
        
        //Find maximum window size of every element
        for(int i=0; i<n; i++){
            int windowSize = right[i] - left[i] - 1;
            
            ans[windowSize - 1] = Math.max(ans[windowSize-1], arr[i]);
        }
        
        //Filling the missing places
        for(int i=n-2; i>=0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int num : ans){
            result.add(num);
        }
        return result;
    }
}