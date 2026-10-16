// TC - O(n)
// SC - O(h) where h is the height of tree & O(n) for skewed tree
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calMaxPathSum(root);
        return maxSum;
    }

    private int calMaxPathSum(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftPathSum = Math.max(0, calMaxPathSum(node.left));
        int rightPathSum = Math.max(0, calMaxPathSum(node.right));

        maxSum = Math.max(maxSum, leftPathSum + rightPathSum + node.val);

        return node.val + Math.max(leftPathSum, rightPathSum);
    }
}