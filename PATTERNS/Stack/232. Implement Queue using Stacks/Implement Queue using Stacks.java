class MyQueue {

    Stack<Integer> input; // SC - O(n)
    Stack<Integer> output; // SC - O(n)

    public MyQueue() {
        input =  new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) { // TC - O(1)
        input.push(x);
    }
    
    public int pop() { // TC - O(1)
        peek();

        return output.pop();
    }
    
    public int peek() { // TC - O(n)
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}