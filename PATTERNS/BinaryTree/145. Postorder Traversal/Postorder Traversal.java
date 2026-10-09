// TC - O(n)
// SC - O(h) -- "h" is the height of the tree

class Solution {

    public void printPostorder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }

        //Left -> Right -> Root
        printPostorder(node.left, res);
        printPostorder(node.right, res);
        res.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        printPostorder(root, res);
        return res;
    }
}