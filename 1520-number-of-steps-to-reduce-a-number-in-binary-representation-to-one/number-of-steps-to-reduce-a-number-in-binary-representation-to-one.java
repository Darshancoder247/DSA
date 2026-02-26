class Solution {
    public int numSteps(String s) {
        int steps=0;
        int cary=0;
        for(int i=s.length()-1;i>0;i--)
        {
            int bit=s.charAt(i)-'0';
            if(bit+cary==1)
            {
                steps+=2;
                cary=1;
            }else{
                steps+=1;
            }
        }
        return steps+cary;
    }
}