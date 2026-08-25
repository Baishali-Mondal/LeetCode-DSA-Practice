
// DFS + Backtracking + Visited matrix
// TC - O(4*(n^2) as each cell has 4 option and more accurate 3 option as up is restricted
// SC - O(n^2)(visited matrix) + O(n^2)(recursion depth)
class Solution {
    
    void solve(int row, int col, int[][] maze, int n, 
                int[][] vis, String path, ArrayList<String> res){
                    
            // Destination Reached i.e the last n-1 * n-1 cell
            if(row == n-1 && col == n-1){
                res.add(path);
                return;
            }
            
            // Directions
            // Down
            if(row+1 < n && vis[row+1][col] == 0 && maze[row+1][col] == 1){
                
                vis[row][col] = 1;
                
                solve(row+1, col, maze, n, vis, path+"D", res);
                
                vis[row][col] = 0;
            }
            
            //Left
            if(col-1 >= 0 && vis[row][col-1] == 0 && maze[row][col-1] == 1){
                
                vis[row][col] = 1;
                
                solve(row, col-1, maze, n, vis, path+"L", res);
                
                vis[row][col] = 0;
            }
            
            //Right
            if(col+1 < n && vis[row][col+1] == 0 && maze[row][col+1] == 1){
                
                vis[row][col] = 1;
                
                solve(row, col+1, maze, n, vis, path+"R", res);
                
                vis[row][col] = 0;
            }
            
            //Up
            if(row-1 >= 0 && vis[row-1][col] == 0 && maze[row-1][col] == 1){
                
                vis[row][col] = 1;
                
                solve(row-1, col, maze, n, vis, path+"U", res);
                
                vis[row][col] = 0;
            }
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        
        ArrayList<String> res = new ArrayList<>();
        
        //Starting cell is blocked
        if(maze[0][0] == 0){
            return res;
        }
        
        int[][] visited = new int[n][n];
         
        solve(0, 0, maze, n, visited, "", res);
        
        return res;
    }
}