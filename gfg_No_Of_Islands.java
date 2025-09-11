//  Here L means Land that we move , W  means Water block area , we move in these 8 directions [4 noraml + 4 diaagonal] 
class Solution {
    int rows; 
    int  cols; 
    public int countIslands(char[][] grid) {
      rows =  grid.length; 
      cols = grid[0].length; 
      boolean[][] vis = new boolean[rows][cols]; 
      int cnt = 0; 
       
      int[][] adj = {{}};
      
      for(int i=0; i<rows; i++)
      {
          for(int j=0; j<cols; j++)
          {
              //  only dfd when not vs and 1 
              if(grid[i][j]  == 'L' && !vis[i][j])
              {   
                  cnt ++ ;
                  dfs(grid,i,j, vis);
              }
          }
      }
      return cnt ;
    } 
    
    public void dfs(char[][] grid , int i , int j , boolean[][] vis)
    {   
        if(i < 0 || i >= rows || j<0 || j>=cols || grid[i][j] == 'W' || vis[i][j]) return; 
        
        vis[i][j] = true; 
        
        // int[][] adjList = {{i-1,j}, {i, j+1} , {i+1,j}, {i,j-1} ,  {i-1,j-1} , {i-1,j+1} ,{i+1,j-1} ,  {i+1,j+1}};        //  8 dir
        int[][] adjList = {
    {i-1, j}, {i, j+1}, {i+1, j}, {i, j-1},
    {i-1, j-1}, {i-1, j+1}, {i+1, j-1}, {i+1, j+1}
};
 
         for(int[]  neigh : adjList)
         {
             dfs(grid, neigh[0], neigh[1] , vis); 
         }
    }
}
