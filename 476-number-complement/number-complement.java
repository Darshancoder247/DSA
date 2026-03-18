class Solution {
    public int findComplement(int num) {
        String binary=Integer.toBinaryString(num);
 
        StringBuilder sb=new StringBuilder();

        for(char c:binary.toCharArray())
        {
            sb.append(c=='0'?'1':'0');
          
        }
        return Integer.parseInt(sb.toString(),2);
    }
}