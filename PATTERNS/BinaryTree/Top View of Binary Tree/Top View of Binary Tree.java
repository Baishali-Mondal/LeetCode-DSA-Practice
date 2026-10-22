// TC - O(n logn) [O(n) for level order traversal & O(logn) for insertion into the TreeMap for n nodes]
// SC - O(n) [O(n)-queue & O(n)-map]

class CustomNode{
    Node node;
    int col;
    
    CustomNode(Node node, int col){
        this.node = node;
        this.col = col;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<CustomNode> que = new LinkedList<>();
        que.offer(new CustomNode(root, 0));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(!que.isEmpty()){
            CustomNode customNode = que.poll();
            Node node = customNode.node;
            int col = customNode.col;
            
            if(!map.containsKey(col)){
                map.put(col, node.data);
            }
            if(node.left != null){
                que.offer(new CustomNode(node.left, col-1));
            }
            if(node.right != null){
                que.offer(new CustomNode(node.right, col+1));
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        
        return res;
    }
}