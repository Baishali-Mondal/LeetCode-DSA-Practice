// TC - O(1)
// SC - O(n)

class MinStack {

    Stack<Long> st;
    long minEle = 0;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        long val = value;
        if(st.isEmpty()){
            st.push(val);
            minEle = val;
        }
        else{
            if(val >= minEle){
                st.push(val);
            }
            else if(val < minEle){
                st.push(2 * val - minEle); // pushing a modified value
                minEle = val;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        else{
            if(st.peek() >= minEle){
                st.pop();
            }
            else if(st.peek() < minEle){
                minEle = 2 * minEle - st.peek();
                st.pop();
            }
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        long topEle = st.peek();

        if(topEle >= minEle){
            return (int)topEle;           
        }
        return (int)minEle;
    }
    
    public int getMin() {
        if(st.size() == 0){
            return -1;
        }
        return (int)minEle;
    }
}