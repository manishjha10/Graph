class Solution {  
    int rows; 
    int cols; 
    public void dfs(int[][] image , int i , int j ,int newColor,  int currentcolor, boolean[][] vis)
    {   
        //  wound case 
        if(i < 0 || i >= rows || j >= cols || j < 0 || image[i][j] != currentcolor || vis[i][j]){
          return;
        }

        image[i][j] = newColor; 
        vis[i][j] = true; 
        
        // 4 directions move. 
        int[][] adjList = { {i-1,j}, {i ,j+1} , {i + 1 , j}, {i , j-1}}; 
        
        for(int[] neigh : adjList){
           dfs(image , neigh[0] , neigh[1] ,newColor,  currentcolor, vis);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length; 
        cols = image[0].length; 
        boolean[][] vis  = new boolean[rows][cols]; 
         

         //  in these source row , sourece column given so we make 1 dfs call and it spread it all sides 
        dfs(image,sr,sc ,color,image[sr][sc] ,vis);
        return  image; 
    }
}
