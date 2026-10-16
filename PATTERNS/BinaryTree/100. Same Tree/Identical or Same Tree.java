// TC - O(n)
// SC - O(h) for recursion stack; worst case-O(n) for skewed tree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){ // both the nodes are null
            return true;
        }
        if(p == null || q == null){ // either of the only one node is null
            return false;
        } 
        if(p.val != q.val){ // node values differ but they need to match
            return false;
        }

        // Comparing both the subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}