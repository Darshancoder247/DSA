class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        // Step 1: Build column heights (consecutive 1s ending at each row)
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] += matrix[r - 1][c];
                }
                // If matrix[r][c] == 0, height resets to 0 (already the case)
            }
        }

        // Step 2: For each row, sort heights and compute max area
        for (int r = 0; r < rows; r++) {
            int[] heights = matrix[r].clone();
            Arrays.sort(heights);                          // Sort ascending

            for (int j = cols - 1; j >= 0; j--) {
                if (heights[j] == 0) break;               // No point continuing

                // (cols - j) columns available at this height
                int area = heights[j] * (cols - j);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}