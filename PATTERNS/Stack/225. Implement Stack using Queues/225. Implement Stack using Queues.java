class MyStack {

    Queue<Integer> q; // SC - O(n)

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) { // TC - O(n)
        q.add(x);

        int size = q.size();
        
        //Moving all front elemets at the back of x
        for(int i=0; i<size-1;i++){
            q.add(q.poll());
        }
    }
    
    public int pop() { //TC - O(1)
        return q.poll();
    }
    
    public int top() { //TC - O(1)
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}