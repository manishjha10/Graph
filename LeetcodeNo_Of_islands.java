
//  Here 1 means allow , 0 means block 
class Solution {
    int rows;
    int cols;
    public void dfs(char[][] grid , int i , int j , boolean[][] vis){
      //  bound cases. 
      if(i < 0 || i >= rows || j >= cols ||  j < 0 || grid[i][j] == '0' || vis[i][j]) return;  

      vis[i][j] = true ;
      int adjList[][] = {{i-1,j} , {i,j+1} , {i+1,j}, {i , j-1}};        //   4 direction check

      for(int neigh[] : adjList)
      { 
        dfs(grid , neigh[0] , neigh[1], vis);      // neigh[0]  row , neigh[1] col 
      }
    } 

    public int numIslands(char[][] grid) {
       rows =  grid.length; 
       cols = grid[0].length; 
      boolean[][] vis = new boolean[rows][cols]; 
      int cnt = 0; 
      
      for(int i=0; i<rows; i++)
      {
          for(int j=0; j<cols; j++)
          {
              //  only dfd when not vs and 1 
              if(grid[i][j]  == '1' && !vis[i][j])
              {   
                  cnt ++ ;
                  dfs(grid,i,j, vis);
              }
          }
      }
      return cnt ;
    }   
}
