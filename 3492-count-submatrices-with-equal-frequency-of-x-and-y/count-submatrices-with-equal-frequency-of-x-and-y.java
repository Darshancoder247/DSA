class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int count=0;
        
        int prefX[][] =new int[m+1][n+1];
        int prefY[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
               prefX[i][j]=(grid[i-1][j-1]=='X'?1:0)+
               prefX[i-1][j]+prefX[i][j-1]-prefX[i-1][j-1];

               prefY[i][j]=(grid[i-1][j-1]=='Y'?1:0)
               +prefY[i-1][j]+prefY[i][j-1]-prefY[i-1][j-1];

               if(prefX[i][j]==prefY[i][j] && prefX[i][j]>0)
               {
                count++;
               }
            }
        }
        return count;
    }
}