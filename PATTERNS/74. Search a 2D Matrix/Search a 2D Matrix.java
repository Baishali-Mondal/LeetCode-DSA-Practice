
//OPTIMAL : IMAGINE A 1D ARRAY AND APPLY BINARY SEARCH
//TC - O(log(m*n))
//SC - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        while( low <= high ){
            int mid = low + (high-low)/2;

            int row = mid/n;
            int col =mid%n;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}

//BETTER - APPLY BINARY SEARCH IN EACH ROW
//TC - O(m logn)
//SC - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i =0; i<m; i++){
            if( target >= matrix[i][0] && target <= matrix[i][n-1]){
                int left = 0;
                int right = n-1;

                while(left <=right){

                    int mid = left + (right-left)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    }else if(matrix[i][mid] > target){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
            }
        }
        return false;
    }
}


//BRUTE : compare with the last element of each row if target is greater move to next row else decrement column
// TC - O(m*n)
// SC - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n-1;

        while(row<m && col>=0){
            if(matrix[row][col] < target){
                row++;
            }
            else if(matrix[row][col] > target){
                col--;
            }
            else if(matrix[row][col] == target){
                return true;
            }
        }
        return false;
    }
}