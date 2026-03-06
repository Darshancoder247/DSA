class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        StringBuilder sb=new StringBuilder();
        char[] hex="0123456789abcdef".toCharArray();

        while(num!=0)
        {
            sb.append(hex[num&15]);
            num>>>=4;
        }

        return sb.reverse().toString();
    }
}