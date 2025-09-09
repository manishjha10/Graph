class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
     ArrayList<Integer> l = new ArrayList<>(); 
     Queue<Integer> q = new LinkedList<>(); 
     boolean[] vis = new boolean[adj.size()]; 
     q.add(0);
    
        while(!q.isEmpty()){
            int curr = q.poll(); 
            
            if(!vis[curr]){
                
                l.add(curr); 
                vis[curr] = true; 
                
                for(int i=0; i<adj.get(curr).size(); i++){
                    int ele = adj.get(curr).get(i); 
                    q.add(ele); 
                }
                
            }
            
        }
    
    
    return l ;
    }
}





