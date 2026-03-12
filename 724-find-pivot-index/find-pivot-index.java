class Solution {
    public int pivotIndex(int[] nums) {  
        int totalSum=0;
        for(int a:nums)
        {
            totalSum+=a;
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++)
        {
            int rightsum=totalSum-leftsum-nums[i];
            if(leftsum==rightsum) return i;
            leftsum+=nums[i];
        }
        return -1;
    }
}