class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int maxWindow=1;
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            while((long)nums[right]>(long)nums[left]*k)
            {
                left++;
            }
            maxWindow=Math.max(maxWindow,right-left+1);

        }
        return n-maxWindow;
    }
}