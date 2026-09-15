// Previous Greater Element + Index Difference
// TC - O(n)
// SC - O(n)

class StockSpanner {
    Stack<int[]> st;
    int index;

    public StockSpanner() {
        st = new Stack<>();
        index = 0;
    }
    
    public int next(int price) {
        
        while(!st.isEmpty() && st.peek()[0] <= price){ // st.peek()[0] --> price && st.peek()[1] --> index of previous greater
            st.pop();
        }

        int span=0;

        if(st.isEmpty()){
            span = index + 1;
        }
        else if(!st.isEmpty() && st.peek()[0] > price){ 
            span = index - st.peek()[1];
        }
        st.push(new int[]{price, index});  
        //[60,3]
        //[70,3]
        //[80,1]
        //[100,0]
        
        index++;

        return span;
    }
}
