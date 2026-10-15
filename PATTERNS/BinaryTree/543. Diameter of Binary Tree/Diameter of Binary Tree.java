// TC - O(n) every node is traversed once
// SC - O(h) height of the tree where it can be O(n) for skewed BT
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calHeightDiam(root);
        return diameter;
    }

    private int calHeightDiam(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftH = calHeightDiam(node.left);
        int rightH = calHeightDiam(node.right);

        //longest path passing through this particular node
        diameter = Math.max(diameter, leftH + rightH);

        //returning the height of every node 
        return 1 + Math.max(leftH, rightH);
    }
}