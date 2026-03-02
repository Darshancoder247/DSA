class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        int res=0;

        for(int i=0;i<n;i++)
        {
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<n;j++)
            {
            if(i==j)
             continue;
            int dx=points[i][0]-points[j][0];
            int dy=points[i][1]-points[j][1];
            int dist=dx*dx+dy*dy;
            int count=map.getOrDefault(dist,0);
            res+=2*count;
            map.put(dist,count+1);
            }

        }
        return res;
    }
}