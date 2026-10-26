
// TC - O(n)
// SC - O(h) - h is the maximum no of nodes in the queue

class Solution {
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            while(size>0){
                Node node = que.poll();
                if(node.left != null){
                    que.offer(node.left);
                }
                if(node.right != null){
                    que.offer(node.right);
                }
                size--;
                if(size == 0){
                    res.add(node.data);
                }
            }
        }
        return res;
    }
}