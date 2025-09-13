class Solution {
    
    public boolean check(int curr , int V, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>(); 
        q.add(curr); 
        color[curr]=0;
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            
            
            for(int neigh: adj.get(node))
            {
                
                if(color[neigh] == -1)
                {
                    
                    color[neigh] = 1 - color[node];   // neighbour is opeeosite color of the currnode 
                    q.add(neigh); 
                }
                
                else if(color[neigh] == color[node])   //  both neighbour are same color 
                {
                    return false; 
                }
            }
        }
        return true; 
    }
    
    public boolean isBipartite(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<>()); 
        }
        for(int i=0; i<edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        int[] color = new int[V];
        for(int i=0;i<V;i++) color[i] = -1 ;
        
        for(int i=0; i<V; i++)
        {
            if(color[i] == -1)
            {
                if(check(i, V, adj, color) == false) 
                {
                    return false;
                }
            }
        }
        return true; 
    }
}
