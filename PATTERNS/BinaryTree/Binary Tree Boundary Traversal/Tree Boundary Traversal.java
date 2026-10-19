// TC - O(n)
// SC - O(h){for the recursion for addLeaves} + O(h){for the temp list} == O(n)

class Solution {
    
    //check if a node is Leaf Node
    private boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    
    // Add all the left boundary node--top to bottom
    private void addLeftBoundary(Node node, ArrayList<Integer> res){
        Node curr = node.left;
        while(curr != null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            curr =  curr.left != null ? curr.left : curr.right;//prefer left child, if absent go for right node
        }
    }
    
    // Add all the leaf nodes from left to right 
    private void addLeaves(Node node, ArrayList<Integer> res){
        if(node == null) return;
        
        if(isLeaf(node)){
            res.add(node.data);
            return;
        }
        
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }
    
    // Add all the right boundary node -- top to bottom & then reverse
    private void addRightBoundary(Node node, ArrayList<Integer> res){
        Node curr = node.right;
        List<Integer> tempList = new ArrayList<>(); //temp list to reverse 
        
        while(curr != null){
            if(!isLeaf(curr)){
                tempList.add(curr.data);
            }
            curr = curr.right != null ? curr.right : curr.left; // prefer right node if right child absent go for left node
        }
        
        for(int i=tempList.size()-1; i>=0; i--){ // reverse the O/P of tempList
            res.add(tempList.get(i));
        }
    }
    
    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        //Root is added at the very first when it is not the leaf node
        if(!isLeaf(root)){
            res.add(root.data);
        }
        
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        
        return res;
    }
}