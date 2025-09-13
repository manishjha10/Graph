class Solution {
    public static void dfs(int curr, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean[] vis)
    {
        vis[curr] = true;
        
        
        for(int neigh : adj.get(curr))
        {
            if(!vis[neigh])
            {   
                dfs(neigh,st,adj,vis); 
            }
        }
        st.push(curr);  //  when we retun then add
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
         boolean[] vis = new boolean[V];
         Stack<Integer> st = new Stack<>(); 
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for(int i=0; i<V; i++)
         {
             adj.add(new ArrayList<>());
         }
         for(int i=0; i<edges.length; i++)
         {
             int u = edges[i][0];
             int v= edges[i][1];
             
             adj.get(u).add(v);   // directed graph
         } 
         
         
         // dfs
         for(int i=0; i<V; i++)
         {
            if(!vis[i])
            {
                dfs(i,st,adj,vis);
            }
         }
            
         ArrayList<Integer> l = new ArrayList<>(); 
         while(!st.isEmpty())
         {
            l.add(st.pop()); 
         }
         return l;
    }
}
