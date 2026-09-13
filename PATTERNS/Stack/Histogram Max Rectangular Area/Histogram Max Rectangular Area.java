// TC - O(n)+O(n)+O(n) == O(n)
// SC - O(n)+O(n)+O(n) = O(n) {right[] + left[] + stack - worst case if the heights rae in increasing order}

class Solution {
    public static int getMaxArea(int heights[]) {
        // code here
        int n = heights.length;

        Stack<Integer> st = new Stack<>(); 
        int[] right = new int[n];
        int[] left = new int[n];

        // Nearest Smallest Element to Left
        for(int i=0; i<n; i++){ // O(n)
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            // if(st.isEmpty()){
            //     left[i] = -1;
            // }
            // else if(!st.isEmpty() && heights[st.peek()] < heights[i]){
            //     left[i] = st.peek();
            // }

            left[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();//Reusing the same stack

        //Nearest Smallest Element to Right
        for(int i=n-1; i>=0; i--){ // O(n)
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            // if(st.isEmpty()){
            //     right[i] = n;
            // }
            // else if(!st.isEmpty() && heights[st.peek()] < heights[i]){
            //     right[i] = st.peek();
            // }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxArea = 0;

        // Calculating the area of the histogram = height * width;
        for(int i=0; i<n; i++){ // O(n)
            int width = right[i] - left[i] -1; 
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
