// TC - O(n)
// SC - O(n)

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        int n = arr.length;

        for(int i=n-1; i>=0; i--){ //traversing the array from right to optimize O(n^2) and storing next greater while traversing

            while(!st.isEmpty() && st.peek() >= arr[i]){ // top > element
                st.pop();
            }

            if(st.isEmpty()){ // stack is empty
                list.add(-1);
            }
            else if(st.size() > 0 && st.peek() < arr[i]){ // top < elemnt
                list.add(st.peek());
            }

            st.push(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
}