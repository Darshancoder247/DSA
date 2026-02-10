class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c:tasks)
        {
            freq[c-'A']++;
        }

      int maxFreq=0;
      for(int f:freq)
      {
        maxFreq=Math.max(f,maxFreq);
      }
      int countMaxFreq=0;
      for(int f:freq)
      {
        if(f==maxFreq) countMaxFreq++;
      }
      int intervals=(maxFreq-1)*(n+1)+countMaxFreq;

      return Math.max(intervals,tasks.length);
      
    }
}