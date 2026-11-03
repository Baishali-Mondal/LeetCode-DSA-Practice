// TC - O(n)
// SC - O(n)
class Solution {
    private boolean isSymmetricHelper(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null) return true;
        if(leftNode == null || rightNode == null) return false;

        return leftNode.val == rightNode.val && 
        isSymmetricHelper(leftNode.left, rightNode.right) && 
        isSymmetricHelper(leftNode.right, rightNode.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetricHelper(root.left, root.right);
    }
}