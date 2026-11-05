// TC - [O(n)- for traversal] & [O(n*h) n=no. of nodes & h=height of the tree --> for traversal and printing] & [O(nlogn) for balanced binary tree]
// SC - O(h)
class Solution {
    public void findAllPaths(Node root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> res){
        if(root == null){
            return;
        }
        
        path.add(root.data);
        
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }else{
            findAllPaths(root.left, path, res);
            findAllPaths(root.right, path, res);
        }
        
        path.remove(path.size()-1);
    }
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path =  new ArrayList<>();
        
        findAllPaths(root, path, res);
        
        return res;
    }
}