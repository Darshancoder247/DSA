class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res =new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String word:words)
        {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(
            (a,b)->{
                if(map.get(a).equals(map.get(b)))
                {
                    return b.compareTo(a);
                }
                return map.get(a)-map.get(b);
            });

            for(String word:map.keySet())
            {
                pq.offer(word);
                if(pq.size()>k)
                {
                    pq.poll();
                }
            }

            while(!pq.isEmpty())
            {
                res.add(pq.poll());
            }
            Collections.reverse(res);
            return res;
    }
}