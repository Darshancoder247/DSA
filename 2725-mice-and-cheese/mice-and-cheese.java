class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int total=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<reward1.length;i++)
        {
            total+=reward2[i];
            int diff=reward1[i]-reward2[i];
            pq.add(diff);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        while(!pq.isEmpty())
        {
            total+=pq.poll();
        }
        return total;
    }
}