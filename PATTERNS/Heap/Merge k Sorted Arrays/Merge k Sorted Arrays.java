// TC : O(N log K) where N is the total number of elements and K is the number of rows
// SC : heap space is O(K).

class Solution {
    
    class Node{
        int value;
        int row;
        int col;
        
        Node(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        
        for(int row=0; row<n; row++){
            pq.add(new Node(mat[row][0], row, 0));
        }
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            res.add(node.value);
            
            if(node.col+1 < m){
                pq.add(new Node(mat[node.row][node.col + 1], node.row, node.col + 1));
            }
        }
        return res;
    }
}