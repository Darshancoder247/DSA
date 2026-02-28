class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1000000007;
        int bitLength = 0;
        
        for (int i = 1; i <= n; i++) {
            
            // If i is power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }
            
            res = ((res << bitLength) + i) % mod;
        }
        
        return (int) res;
    }
}