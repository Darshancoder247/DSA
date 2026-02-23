class Solution {
    public int[] numberGame(int[] nums) {
        int arr[]=new int[nums.length];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums)
        {
         pq.add(num);
        }
        int i=0;
        while(!pq.isEmpty())
        {
          int first=pq.poll();
          int second=pq.poll();
          arr[i++]=second;
          arr[i++]=first;
        }
        return arr;
    }
}