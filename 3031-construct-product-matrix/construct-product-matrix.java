class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD=12345;
        int m=grid.length;
        int n=grid[0].length;
        int total=m*n;
    
       int prefix[]=new int[total];
       int suffix[]=new int[total];

       prefix[0]=1;
       for(int i=1;i<total;i++)
       {
         int row=(i-1)/n,col=(i-1)%n;
         prefix[i]=(int)((long)prefix[i-1]*grid[row][col]%MOD);
       }


          suffix[total-1]=1;
         for(int i=total-2;i>=0;i--)
       {
         int row=(i+1)/n,col=(i+1)%n;
         suffix[i]=(int)((long)suffix[i+1]*grid[row][col]%MOD);
       }

     


       int[][] p=new int[m][n];
       for(int j=0;j<total;j++)
       {
        int row=j/n,col=j%n;
        p[row][col]=(int)((long)prefix[j]*suffix[j]%MOD);
       }
       return p;
    }
}