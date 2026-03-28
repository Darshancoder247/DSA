class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];

        // Phase 1: Greedily assign characters
        char next = 'a';
        for (int i = 0; i < n; i++) {
            if (s[i] != 0) continue; // Already assigned via an earlier match

            if (next > 'z') return ""; // Ran out of characters

            s[i] = next++;

            // Propagate: any j > i that shares a prefix with i gets the same char
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    if (s[j] != 0 && s[j] != s[i]) return ""; // Conflict
                    s[j] = s[i];
                }
            }
        }

        // Phase 2: Validate the LCP matrix against the built string
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Compute expected lcp[i][j]
                int expected;
                if (s[i] != s[j]) {
                    expected = 0;
                } else {
                    // lcp[i][j] = 1 + lcp[i+1][j+1], boundary = 0
                    expected = 1 + (i + 1 < n && j + 1 < n ? lcp[i + 1][j + 1] : 0);
                }

                if (lcp[i][j] != expected) return "";
            }
        }

        return new String(s);
    }
}