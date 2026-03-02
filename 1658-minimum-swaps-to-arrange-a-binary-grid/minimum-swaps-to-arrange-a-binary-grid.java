class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];
        
        // Step 1: Count trailing zeros for each row
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = n - 1; j >= 0; j--) {
                if(grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            zeros[i] = count;
        }
        
        int swaps = 0;
        
        // Step 2: Arrange rows
        for(int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;
            
            // Find row with enough trailing zeros
            while(j < n && zeros[j] < needed) {
                j++;
            }
            
            if(j == n) return -1; // Not possible
            
            // Bring row j to position i
            while(j > i) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                j--;
                swaps++;
            }
        }
        
        return swaps;
    }
}