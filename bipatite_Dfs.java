//  Leetcode- 758 :  given graph is already an adjacency list. 
class Solution {
    public boolean check(int curr ,int V ,int[][] graph, int[] color)
    {
        for(int neigh :  graph[curr])
        {
            if(color[neigh] == -1)
            {
                color[neigh] = 1 - color[curr];    //  say  0[yellow] ,1[green] are color. 
                if(check(neigh, V, graph, color) == false)
                {
                    return false;
                }
            }
            //  After all dfs call then we check is there same color occur or not 
            else if(color[neigh] == color[curr])
            {
                return false;
            }
        }
        return true;  
    }
    public boolean isBipartite(int[][] graph) {
        //Graph is already and adjacency list form. 


        int[] color = new int[graph.length];
        for(int i=0; i<graph.length; i++) color[i] = -1; 



        for(int i=0; i<graph.length; i++)
        {   
            if(color[i] == -1){
              if(check(i, graph.length, graph, color) == false){
                return false;
              }
            }    
        }

      return true;
    }
}
