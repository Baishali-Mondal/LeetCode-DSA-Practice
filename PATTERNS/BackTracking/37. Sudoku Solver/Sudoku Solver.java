// Backtracking + Contraint Checking
// TC - O(9^81) == O(1) constant 
// SC - O(1)
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for( int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char d = '1'; d <= '9'; d++){

                        //BackTracking
                        if(isValidBox(board, i, j, d)){
                            board[i][j] = d;  //pick

                            if(solve(board)){ //explore
                                return true;
                            }

                            board[i][j] = '.'; //backtrack or undo
                        }
                    }
                    return false;
                }
            }
        }
        return true; //if non of the rows contain '.' i.e sudku solved
    }

    boolean isValidBox(char[][] board, int row, int col, int d){

        //validation check of each row and respective column
        for( int i=0; i<9; i++){
            if(board[row][i] == d) return false;
            if(board[i][col] == d) return false;
        }

        //validation check for a 3*3 matrix
        int startRow = (row/3) * 3; //logic to find the index of a 3*3 matrix in a 9*9 matrix
        int startCol = (col/3) * 3;

        for(int i = startRow; i<startRow+3; i++){
            for(int j = startCol; j<startCol+3; j++){
                if(board[i][j] == d){
                    return false;
                }
            }
        }


        // for(int k=0; k<3; k++){
        //     for(int l=0; l<3; l++){
        //         if(board[startRow + k][startCol + l] == d){
        //             return false;
        //         }
        //     }
        // }
        return true;
    }
}