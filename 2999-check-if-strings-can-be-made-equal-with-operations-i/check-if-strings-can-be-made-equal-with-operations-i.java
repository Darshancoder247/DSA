class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;

        int[] oddfreq=new int[26];
        int[] evenfreq=new int[26];

        for(int i=0;i<s1.length();i++)
        {
            if(i%2==0)
            {
                evenfreq[s1.charAt(i)-'a']++;
                evenfreq[s2.charAt(i)-'a']--;
            }
            else
            {
                oddfreq[s1.charAt(i)-'a']++;
                oddfreq[s2.charAt(i)-'a']--;
            }
        }

        for(int i=0;i<26;i++)
        {
            if(oddfreq[i]!=0 || evenfreq[i]!=0) return false;
        }
        return true;
    }
}