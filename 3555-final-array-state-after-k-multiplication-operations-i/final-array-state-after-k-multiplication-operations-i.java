class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        // Min heap storing {value, index}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];   // smaller index first
                return a[0] - b[0];       // smaller value first
            }
        );

        // Insert value + index
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            curr[0] *= multiplier;     // multiply value
            nums[curr[1]] = curr[0];   // update original array
            pq.add(curr);              // push back
        }

        return nums;
    }
}