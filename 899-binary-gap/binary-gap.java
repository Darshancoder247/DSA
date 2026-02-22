class Solution {
    public int binaryGap(int n) {
        int maxGap=0;
        int lastIndex=-1;
        int index=0;
        while(n>0)
        {
            if((n&1)==1)
            {
                if(lastIndex!=-1)
                {
                    maxGap=Math.max(maxGap,index-lastIndex);
                }
                 lastIndex=index;
                
            }
               n= n>>1;
                index++;
        }
        return maxGap;
    }
}