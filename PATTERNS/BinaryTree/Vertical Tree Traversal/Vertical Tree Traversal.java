// TC - O(nlogn) -> O(n)for DFS traversal & O(log n)for TreeMap traversal
// SC - O(n)
class Solution {
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
    
    private void dfs(Node root, int col, int level){
        if(root == null) return;
        
        //[Col -> [level -> [list]]]
        //Storing in the Map 
        if(!map.containsKey(col)){ //based on column 
            map.put(col, new TreeMap<>());
        }
        if(!map.get(col).containsKey(level)){ //based on row
            map.get(col).put(level, new ArrayList<>());
        }
        map.get(col).get(level).add(root.data);
        
        dfs(root.left, col-1, level+1);
        dfs(root.right, col+1, level+1);
    }
    
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      
      if(root == null){
          return res;
      }
      
      dfs(root, 0, 0);
      
      //sorting based on column
      for(Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : map.entrySet()){
          TreeMap<Integer, ArrayList<Integer>> levelMap = entry.getValue();
          ArrayList<Integer> list = new ArrayList<>();
          
          //sorting based on level or row
          for(Map.Entry<Integer, ArrayList<Integer>> subEntry : levelMap.entrySet()){
              ArrayList<Integer> subList = subEntry.getValue();
            //   Collections.sort(subList);
              list.addAll(subList);
          }
          res.add(list);
      }
      return res;
      
    }
}