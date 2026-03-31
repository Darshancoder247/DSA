import java.util.Arrays;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int len = n + m - 1;
        char[] word = new char[len];
        boolean[] locked = new boolean[len];

        // Step 1 & 2: fill 'a', then stamp str2 at every 'T' position
        Arrays.fill(word, 'a');

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (locked[i + j] && word[i + j] != str2.charAt(j)) {
                        return ""; // conflict between two 'T' placements
                    }
                    word[i + j] = str2.charAt(j);
                    locked[i + j] = true;
                }
            }
        }

        // Step 3: fix 'F' windows that accidentally equal str2
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                // Check if window [i, i+m-1] == str2
                boolean equal = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        equal = false;
                        break;
                    }
                }

                if (equal) {
                    // Find rightmost unlocked position to minimise lex impact
                    boolean fixed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!locked[i + j]) {
                            // Smallest char that differs from str2[j]
                            word[i + j] = (str2.charAt(j) == 'a') ? 'b' : 'a';
                            fixed = true;
                            break;
                        }
                    }
                    if (!fixed) return ""; // all positions locked → impossible
                }
            }
        }

        return new String(word);
    }
}