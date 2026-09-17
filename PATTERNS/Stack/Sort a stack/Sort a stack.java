// TC  = O(n²)
// SC = O(n)

class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }
        
        // Remove top
        int top = st.pop();
        
        sortStack(st); // sort remaining stack
        
        insert(st, top);
    }
    
    public void insert(Stack<Integer> st, int value){
        if(st.isEmpty() || st.peek() <= value){
            st.push(value);
            return;
        }
        
        // Remove larger element
        int top = st.pop();
        
        // Insert value into remaining stack
        insert(st, value);
        
        st.push(top); // Put back the element that was removed
    }
}