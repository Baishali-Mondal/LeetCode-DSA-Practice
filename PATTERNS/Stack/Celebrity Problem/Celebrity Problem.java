class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        
        int top = 0;
        int down = n-1;
        
        // Find the possible candidate
        
        while(top < down){  // TC-O(n)
            if(mat[top][down] == 1){
                top++; //top is not a celebrity
            }
            else { //down is not celebrity
                down--;
            }
        }
        
        int candidate = top;
        
        // Verify the candidate
        for(int i=0; i<n; i++){ // TC-O(n)
            if(i == candidate ){ //diagonal
                continue;
            }
            //candidate should not know anybody
            //everyone should know the candidate
            if(mat[candidate][i] == 1 || mat[i][candidate] == 0){
                return -1;
            }
        }
        return candidate;
    }
}