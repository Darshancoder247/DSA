class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     List<Integer> res=new ArrayList<>();
     if(s.length()<p.length()) return res;
     int[] pCount=new int[26];
     int[] wCount=new int[26];

     for(char ch:p.toCharArray())
     {
        pCount[ch-'a']++;
     }
     int wsize=p.length();
     for(int i=0;i<wsize;i++)
     {
        wCount[s.charAt(i)-'a']++;
     }
     if(Arrays.equals(pCount,wCount))
     {
        res.add(0);
     }
     for(int i=wsize;i<s.length();i++)
     {
        wCount[s.charAt(i)-'a']++;
        wCount[s.charAt(i-wsize)-'a']--;
        if(Arrays.equals(pCount,wCount))
        {
            res.add(i-wsize+1);
        }
     }
     return res;
    }
}