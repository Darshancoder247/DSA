class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long lo = 0, hi = (long) 1e18;

        while (lo < hi) {
            long mid = (lo + hi) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {
        long totalReduction = 0;

        for (int w : workerTimes) {
            // Find max x where w * x*(x+1)/2 <= time
            // Binary search for x
            long lo = 0, hi = mountainHeight;
            while (lo < hi) {
                long mid = (lo + hi + 1) / 2;
                if (w * mid * (mid + 1) / 2 <= time) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            totalReduction += lo;
            if (totalReduction >= mountainHeight) return true; // early exit
        }

        return totalReduction >= mountainHeight;
    }
}