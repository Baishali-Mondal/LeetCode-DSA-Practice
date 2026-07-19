//TC - O(m*n)
//SC - O(1)

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {  
        int m = matrix.length; //rows
        int n = matrix[0].length; //columns

        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;

        List<Integer> res = new ArrayList<>();

        int dir = 0;

        while(top<=down && left<=right){
            if( dir == 0){ //LEFT TO RIGHT
                //const = top i.e row
                for( int i=left; i<=right; i++){
                    res.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){// TOP TO DOWN
                //const = column i.e right
                for( int i=top; i<=down; i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }
            else if( dir == 2){// RIGHT TO LEFT
                 //const = row ie down
                for(int i=right; i>=left; i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }
            else if( dir == 3 ){// DOWN TO UP
                // const =column ie left
                for( int i=down; i>=top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1) % 4;
        }
        return res;
    }
}