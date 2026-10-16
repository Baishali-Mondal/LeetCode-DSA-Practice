// TC - O(n)
// SC - O(w) where w is max no of nodes in the queue at a particular level
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean left2right = true;

        while(!q.isEmpty()){
            int size = q.size();
            Integer[] level = new Integer[size];

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();

                int index = left2right ? i : size-1-i;
                level[index] = node.val;

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(Arrays.asList(level));

            left2right = !left2right;
        }
        return res;
    }
}