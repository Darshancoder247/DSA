class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones)
        {
            minHeap.add(stone);
        }
        while(minHeap.size()>1)
        {
            int y=minHeap.poll();
            int x=minHeap.poll();
            if(x!=y)
            {
                minHeap.add(y-x);
            }
        }
        return minHeap.isEmpty()?0:minHeap.peek();
    }
}