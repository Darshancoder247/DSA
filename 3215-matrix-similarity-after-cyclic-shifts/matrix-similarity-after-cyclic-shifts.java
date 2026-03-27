class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Effective shift (full rotations don't change anything)
        int shift = k % cols;

        // No actual shift occurred
        if (shift == 0) return true;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r % 2 == 0) {
                    // Even row: shifted RIGHT by k
                    // mat[r][c] should equal mat[r][(c - shift + cols) % cols]
                    if (mat[r][c] != mat[r][(c - shift + cols) % cols]) {
                        return false;
                    }
                } else {
                    // Odd row: shifted LEFT by k
                    // mat[r][c] should equal mat[r][(c + shift) % cols]
                    if (mat[r][c] != mat[r][(c + shift) % cols]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}