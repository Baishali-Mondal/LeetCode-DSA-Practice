// OPTIMAL - TRANSPOSE AND REVERSE EVERY ROW
// TC - O(n*n)
// SC - O(1)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Transpose - (rows becomes the columns)
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                //swap elements at diagonal mirror image
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse every row
        for(int i=0; i<n; i++){
            int left = 0;
            int right = n-1;

            while(left<right){
                //swap left and right elements in a row
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}


// BRUTE - USING EXTRA MATRIX AND COPY THEM BACK TO ORIGINAL MATRIX
// TC - O(n*n)
// SC - O(n*n)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];

        // Traversing the matrix
        for(int row=0; row<n; row++){ //O(n*n) 
            for(int col=0; col<n; col++){
                temp[col][n-1-row] = matrix[row][col];
            }
        }

        // Copying the matrix back to original matrix
        for(int row=0; row<n; row++){ //O(n*n)
            for(int col=0; col<n; col++){
                matrix[row][col] = temp[row][col];
            }
        }
    }
}