// Time Complexity = O(n)
// Space Complexity = O(n) 
// Consecutive smaller before the ith index -> Next Greater to left concept(index) - ith index

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop(); // arr[top's index] <= arr --> pop
            }
            
            if(st.isEmpty()){
                list.add(i + 1); // if empty we need to push -1 so [index - (-1)]
            }
            else if(!st.isEmpty() && arr[st.peek()] > arr[i]){
                list.add(i - st.peek());  // index[arr] - index[NGL]
            }
            
            st.push(i); //pushing the index of the NGL element
        }
        return list;
    }
}