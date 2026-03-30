class Solution {
    public boolean checkStrings(String s1, String s2) {
        // Collect chars at even and odd indices for both strings
        char[] even1 = new char[s1.length() / 2 + s1.length() % 2];
        char[] even2 = new char[s2.length() / 2 + s2.length() % 2];
        char[] odd1  = new char[s1.length() / 2];
        char[] odd2  = new char[s2.length() / 2];

        int ei = 0, oi = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even1[ei] = s1.charAt(i);
                even2[ei] = s2.charAt(i);
                ei++;
            } else {
                odd1[oi] = s1.charAt(i);
                odd2[oi] = s2.charAt(i);
                oi++;
            }
        }

        // Sort and compare even-indexed chars, then odd-indexed chars
        Arrays.sort(even1);
        Arrays.sort(even2);
        Arrays.sort(odd1);
        Arrays.sort(odd2);

        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
    }
}