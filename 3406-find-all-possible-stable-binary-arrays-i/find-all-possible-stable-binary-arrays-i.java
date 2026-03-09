class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = 1_000_000_007;

        long[][][] dp = new long[zero + 1][one + 1][2];
        // colSum[i][j] = sum_{t=0}^{i} dp[t][j][1]
        // rowSum[i][j] = sum_{t=0}^{j} dp[i][t][0]
        long[][] colSum = new long[zero + 1][one + 1];
        long[][] rowSum = new long[zero + 1][one + 1];

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if (i == 0 && j == 0) {
                    // empty — no valid array
                } else if (i == 0) {
                    // all ones: valid only if j <= limit
                    dp[0][j][1] = (j <= limit) ? 1 : 0;
                } else if (j == 0) {
                    // all zeros: valid only if i <= limit
                    dp[i][0][0] = (i <= limit) ? 1 : 0;
                } else {
                    // End with 0: preceded by any 1-to-limit zeros from rows above
                    dp[i][j][0] = (colSum[i-1][j]
                                  - (i > limit ? colSum[i-1-limit][j] : 0)
                                  + MOD) % MOD;

                    // End with 1: preceded by any 1-to-limit ones from cols to the left
                    dp[i][j][1] = (rowSum[i][j-1]
                                  - (j > limit ? rowSum[i][j-1-limit] : 0)
                                  + MOD) % MOD;
                }

                // Update prefix sums
                colSum[i][j] = ((i > 0 ? colSum[i-1][j] : 0) + dp[i][j][1]) % MOD;
                rowSum[i][j] = ((j > 0 ? rowSum[i][j-1] : 0) + dp[i][j][0]) % MOD;
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}