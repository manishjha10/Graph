
// TC O(N*M); 
class Solution { 
    class Pair
    {
        int row;
        int col;
        int tm; 
       
        Pair(int row , int col , int tm){
            this.row= row ; this.col=col; this.tm=tm; 
        }
    }
    public int orangesRotting(int[][] grid) {
      int n = grid.length; 
      int m = grid[0].length; 
      Queue<Pair>  q = new LinkedList<>(); 
      int[][] vis = new int[n][m]; 
      int canFresh = 0; 
      
      //  S1 )  grid all level wise add kro vis mark kro fresh oranges coutn kro. 
      for(int i=0; i<n; i++)
      {
          for(int j=0; j<m; j++)
          {
              if(grid[i][j] == 2)      //  they are come to rotten the fresh oranges.
              {
                   q.add(new Pair(i , j, 0));     //  level wise all add. 
                   vis[i][j] = 2 ;
              }
              else
              {
                  vis[i][j] = 0;  // empty; 
              }
              
              if(grid[i][j] == 1) canFresh ++ ;
          }
      }
      
      int tm = 0; 
      int[] drow = {-1,0,1,0};
      int[] dcol = {0,1,0,-1}; 
      int cnt  = 0;
      
    while(!q.isEmpty()){
          int r = q.peek().row;
          int c = q.peek().col;
          int t = q.peek().tm; 
          tm =  Math.max(tm, t);
          q.remove(); 
          
          
         for(int i=0; i<4; i++){
          
          int nrow = r + drow[i];
          int ncol = c + dcol[i]; 
          
          
          //  valid case then   fresh count.[it is call for the fresh so rootten not allowed]
          if(nrow  >= 0 &&  nrow < n && ncol >= 0 &&  ncol < m &&  vis[nrow][ncol] != 2 &&  grid[nrow][ncol] == 1)
          {  
              q.add(new Pair( nrow , ncol , t+1));
              vis[nrow][ncol] = 2 ;       //  mark it as visited. 
              cnt ++; 
          }
       }
      
    }
    
      if(cnt != canFresh) return -1; 
      return tm; 
    }
}




