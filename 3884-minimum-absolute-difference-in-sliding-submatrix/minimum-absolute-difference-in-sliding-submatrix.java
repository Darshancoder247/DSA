class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int row=m-k+1;
        int col=n-k+1;
        int[][] ans=new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                ans[i][j]=minAbsDiffMatrix(grid,i,j,k);
            }
        }
        return ans;
    }

    private int minAbsDiffMatrix(int[][]grid,int i,int j,int k)
    {
        int vals[]=new int[k*k];
        int idx=0;
        for(int r=i;r<i+k;r++)
        {
            for(int c=j;c<j+k;c++)
            {
               vals[idx++]=grid[r][c];
            }
        }

        Arrays.sort(vals);
        int mindiff=Integer.MAX_VALUE;
        for(int f=1;f<vals.length;f++)
        {
            if(vals[f]!=vals[f-1])
            {
                mindiff=Math.min(mindiff,vals[f]-vals[f-1]);
            }
        }

        return mindiff==Integer.MAX_VALUE?0:mindiff;
    }
}