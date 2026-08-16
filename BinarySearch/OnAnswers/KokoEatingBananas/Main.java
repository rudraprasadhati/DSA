package BinarySearch.OnAnswers.KokoEatingBananas;

class Solution {
//Brute force solution
//Time complexity: O(n + (max*n) = O(max*n)
//Space complexity: O(1)
//    public int kokoEatingBananas(int[] nums, int h) {
//        int maxBanana = Integer.MIN_VALUE;
//        for(int i = 0; i<nums.length; i++) {
//            maxBanana = Math.max(maxBanana, nums[i]);
//        }
//        for(int i = 1; i<=maxBanana; i++) {
//            long minHours = 0;
//            for(int j = 0; j<nums.length; j++) {
//                minHours+=(long)Math.ceil((double) nums[j]/i);
//            }
//            if(minHours<=(long)h) {
//                return i;
//            }
//        }
//        return -1;
//    }

//Optimal solution
    public int kokoEatingBananas(int[] nums, int h) {
        int res = -1;
        int maxBanana = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            maxBanana = Math.max(maxBanana, nums[i]);
        }
        int low = 1;
        int high = maxBanana;
        while(low<=high) {
            int mid = low+((high-low)/2);
            long minHours = 0;
            for(int i = 0; i<nums.length; i++) {
                minHours+=(long) Math.ceil((double) nums[i]/mid);
            }
            if(minHours<=h) {
                res = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {7, 15, 6, 3};
        int h = 8;
        Solution s = new Solution();
        int res = s.kokoEatingBananas(arr, h);
        System.out.println("So Koko should eat "+res+" bananas per hour to finish under "+h+"hrs.");

    }
}

//Time complexity: O(n + (log max * n) = O(log max * n)
//Space complexity: O(1)
