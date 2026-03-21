class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
       int top=x,bottom=x+k-1;
       while(top<bottom)
       {
            for(int c=y;c<y+k;c++)
            {
                int temp=grid[top][c];
                grid[top][c]=grid[bottom][c];
                grid[bottom][c]=temp;
            }
            top++;
            bottom--;
       }
        return grid;
    }
}