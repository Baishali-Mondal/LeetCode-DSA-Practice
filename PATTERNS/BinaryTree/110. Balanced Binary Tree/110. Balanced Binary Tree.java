// TC - O(n)
// SC - O(h) -'h' is the height of tree ["h" is "logn"->for Balanced Binary Tree & "n"->for Skewed binary tree]

class Solution {
    private int checkBalanced(TreeNode node){
        if(node == null){
            return 0;
        }

        int lefth = checkBalanced(node.left);
        if(lefth == -1) return -1;

        int righth = checkBalanced(node.right);
        if(righth == -1) return -1;

        // if(Math.abs(lefth - righth) > 1){
        //     return -1;
        // }

        return (Math.abs(lefth - righth) > 1) ? -1 : Math.max(lefth, righth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root) == -1 ? false : true;
    }
}

// TC - O(n*n) - each node and it's height is visited twice
// SC - O(h) - recursion stack space
class Solution {
    public int calcHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        
        return Math.max(calcHeight(node.left), calcHeight(node.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}