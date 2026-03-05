class Solution {
    public int minOperations(String s) {
        int startWithZero = 0;
        int startWithOne = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i % 2 == 0) {
                if (s.charAt(i) != '0') startWithZero++;
                if (s.charAt(i) != '1') startWithOne++;
            } 
            else {
                if (s.charAt(i) != '1') startWithZero++;
                if (s.charAt(i) != '0') startWithOne++;
            }
        }

        return Math.min(startWithZero, startWithOne);
    }
}