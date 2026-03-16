import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                set.add(grid[r][c]); // single cell rhombus

                int maxSize = Math.min(Math.min(c, n - c - 1), (m - r - 1) / 2);

                for (int k = 1; k <= maxSize; k++) {

                    int sum = 0;

                    int x = r;
                    int y = c;

                    // down-left
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + i][y - i];
                    }

                    // down-right
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + k + i][y - k + i];
                    }

                    // up-right
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + 2 * k - i][y + i];
                    }

                    // up-left
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + k - i][y + k - i];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int i = 0;
        for (int val : set) {
            if (i == size) break;
            ans[i++] = val;
        }

        return ans;
    }
}