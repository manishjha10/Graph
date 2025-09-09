class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void  dfsRec(ArrayList<ArrayList<Integer>> adj ,  ArrayList<Integer> l , int curr , boolean[] vis)
    {
        // s1) curr visite kro print kro and visit mark kro. 
        l.add(curr);
        vis[curr] = true; 
        
        //s2) curr ka neightbours agr nhi ae hai abhe tk to unko add kr rec ke help sa and mark kro
        for(int i=0; i<adj.get(curr).size(); i++){
            int neighbour = adj.get(curr).get(i);   // curr pick
            if(!vis[neighbour.dest)
            {
                dfsRec(adj, l, neighbour.dest , vis);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> l = new  ArrayList<>(); 
        dfsRec(adj, l, 0, new boolean[adj.size()]); 
        return l ;
        
    }
}
