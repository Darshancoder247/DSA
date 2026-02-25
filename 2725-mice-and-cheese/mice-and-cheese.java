class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int total = 0;
        
        int[] diff = new int[n];
        
        for(int i = 0; i < n; i++) {
            total += reward2[i];   // assume mouse 2 eats all
            diff[i] = reward1[i] - reward2[i];
        }
        
        Arrays.sort(diff);
        
        // pick top k differences
        for(int i = n - 1; i >= n - k; i--) {
            total += diff[i];
        }
        
        return total;
    }
}