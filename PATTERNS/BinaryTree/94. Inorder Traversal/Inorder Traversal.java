// TC - O(n)
// SC - O(h) -- "h" is the height of the tree

class Solution {

    public void printInorder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }

        // LEFT -> ROOT -> RIGHT
        printInorder(node.left, res);
        res.add(node.val);
        printInorder(node.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        printInorder(root, res);
        return res;
    }
}