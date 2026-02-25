import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] nums = new Integer[arr.length];
        
        // Convert int[] to Integer[]
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        
        Arrays.sort(nums, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA == countB) {
                return a - b;   // sort normally if same bit count
            }
            
            return countA - countB; // sort by bit count
        });
        
        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        
        return arr;
    }
}