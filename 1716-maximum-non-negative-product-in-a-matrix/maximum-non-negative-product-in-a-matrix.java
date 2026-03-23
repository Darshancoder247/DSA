class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long MOD = 1_000_000_007;

        // Track both max and min products at each cell
        long[][] dpMax = new long[m][n];
        long[][] dpMin = new long[m][n];

        dpMax[0][0] = dpMin[0][0] = grid[0][0];

        // Fill first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dpMax[0][j] = dpMin[0][j] = dpMax[0][j-1] * grid[0][j];
        }

        // Fill first column (can only come from above)
        for (int i = 1; i < m; i++) {
            dpMax[i][0] = dpMin[i][0] = dpMax[i-1][0] * grid[i][0];
        }

        // Fill rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                if (val >= 0) {
                    dpMax[i][j] = val * Math.max(dpMax[i-1][j], dpMax[i][j-1]);
                    dpMin[i][j] = val * Math.min(dpMin[i-1][j], dpMin[i][j-1]);
                } else {
                    // Negative flips max <-> min
                    dpMax[i][j] = val * Math.min(dpMin[i-1][j], dpMin[i][j-1]);
                    dpMin[i][j] = val * Math.max(dpMax[i-1][j], dpMax[i][j-1]);
                }
            }
        }

        long result = dpMax[m-1][n-1];
        return result < 0 ? -1 : (int)(result % MOD);
    }
}
