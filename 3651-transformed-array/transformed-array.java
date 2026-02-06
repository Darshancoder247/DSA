class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[nums.length];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                int idx=(i+nums[i])%n;
                arr[i]=nums[idx];
            }
            else if(nums[i]<0)
            {
                int steps=Math.abs(nums[i])%n;
                int idx=(i-steps+n)%n;
                arr[i]=nums[idx];
            }
            else 
            {
                arr[i]=nums[i];
            }
        }
        return arr;
    }
}