// TC - O(n)
// SC - O(h) -- "h" is the height of the tree
 
class Solution {

    public void printPreorder(TreeNode node, List<Integer> res){
      
        if(node == null){
            return;
        }

        // Root -> Left -> Right
        res.add(node.val);
        printPreorder(node.left, res);
        printPreorder(node.right, res);
  
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();

        printPreorder(root, res);
        return res;
    }
}