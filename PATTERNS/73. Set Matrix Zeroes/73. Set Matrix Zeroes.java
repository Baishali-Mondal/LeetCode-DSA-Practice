
//Using in place
// TC - O(m*n)
// SC - O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;      //no of rows
        int n = matrix[0].length;   //no of columns

        boolean firstRowZero = false;
        boolean firstColZero = false;

        //check first column seperately
        for(int row=0; row<m; row++){
            if(matrix[row][0] == 0){
                firstColZero = true;
            }
        }
        //check first row seperately
        for(int col=0; col<n; col++){
            if(matrix[0][col] == 0){
                firstRowZero = true;
            }
        }

        //Setting the row marker and column marker as zero wrt to matrix excluding the first row and first col
        for(int row=1; row<m; row++){
            for(int col=1; col<n; col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        //Changing the matrix except the first row/col based on the impacted row and col
        for(int row=1; row<m; row++){
            for(int col=1; col<n; col++){
                if(matrix[row][0] == 0 ||  matrix[0][col] == 0){
                    matrix[row][col] = 0;
                 }
            }
        }

        //Lastly changing the impacted row
        if(firstRowZero){
            for(int col=0; col<n; col++){
                matrix[0][col] = 0;
            }
        }

        // Lastly changing the impacted column
        if(firstColZero){
            for(int row=0; row<m; row++){
                matrix[row][0] = 0;
            }
        }
    }
}

//Using m+n boolean(row+col) extra space
// TC - O(m*n)
// SC - O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;      //no of rows
        int n = matrix[0].length;   //no of columns

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
	
	//Marking the row and column as True for the impacted row/col
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}