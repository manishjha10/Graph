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
        st.push(curr);      //  when we retun then add
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
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
         
         
         // bfs : Kahn Algo. 
         
         // S1)  indegree find.
         int[] indegree = new int[V];
         for(int i=0; i<adj.size(); i++)
         {
             for(int v : adj.get(i))
             {
                 indegree[v]++;
             }
         }
         Queue<Integer> q  = new LinkedList<>();
         // s2)  0 degree first add krega queue ma 
         
         for(int i=0; i<V; i++)
         {
             if(indegree[i] ==0)
             {
                 q.add(i);
             }
         }
         
         //S3)
         ArrayList<Integer> res  = new ArrayList<>();
         while(!q.isEmpty())
         {
             int node = q.poll();
             res.add(node);
              
             // indegree neighbour visit 
             for(int neigh : adj.get(node))
             {
              indegree[neigh]--; 
              if(indegree[neigh] == 0)
              {
                  q.add(neigh); 
              }
             }
         }
         
         return res;
        
    }
}
