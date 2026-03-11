class Solution {
    public int bitwiseComplement(int n) {
       if(n==0) return 1;

       int numBits=Integer.SIZE-Integer.numberOfLeadingZeros(n);

       int mask=(1<<numBits)-1;

       return n^mask; 
    }
}