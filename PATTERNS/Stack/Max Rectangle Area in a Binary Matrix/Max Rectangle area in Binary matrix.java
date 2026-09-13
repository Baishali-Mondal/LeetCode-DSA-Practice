// TC - O(rows*cols)
// SC - O(cols)
// Implemented the Maximum Area Histogram problem for each individual row

class Solution {
    public int maxArea(int mat[][]) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;
        int maxArea = 0;
        
        int[] histogram = new int[cols]; // SC - O(cols)
        
        for(int i=0; i<rows; i++){
            
            //Buils histogram for each individual row
            for(int j=0; j<cols; j++){ //O(cols)
                if(mat[i][j] == 1){
                    histogram[j]++;
                }
                else{ // if the row has '0' as input the building can;t fly so replace the etire above  sum to '0'
                    histogram[j] = 0; 
                }
            }
            
            //Finding the largest area for this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(histogram)); //O(cols)
        }
        return maxArea;
    }
    
    
    // Code to find the Max Histogram Area
    public static int largestRectangleArea(int heights[]) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();  // SC - O(cols)
        int[] right = new int[n];
        int[] left = new int[n];

        // Nearest Smallest Element to Left
        for(int i=0; i<n; i++){ // O(cols)
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();//Reusing the same stack

        //Nearest Smallest Element to Right
        for(int i=n-1; i>=0; i--){ // O(cols)
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int currArea = 0;

        // Calculating the area of the histogram = height * width;
        for(int i=0; i<n; i++){ // O(cols)
            int width = right[i] - left[i] -1; 
            currArea = Math.max(currArea, heights[i] * width);
        }

        return currArea;
    }
}