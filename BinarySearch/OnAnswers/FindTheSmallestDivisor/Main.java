package BinarySearch.OnAnswers.FindTheSmallestDivisor;

class Solution {
//Brute force solution
//Time complexity: O(n + (max*n) = O(max*n)
//Space complexity: O(1)
//    public int findTheSmallestDivisor(int[] nums, int limit) {
//        int res = -1;
//        int maxBound = Integer.MIN_VALUE;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]>maxBound) {
//                maxBound = nums[i];
//            }
//        }
//        for(int i = 1; i<=maxBound; i++) {
//            int divisorSum = 0;
//            for(int j = 0; j<nums.length; j++) {
//                double quotient = (double) nums[j] /i;
//                divisorSum+=(int)Math.ceil(quotient);
//            }
//            if(divisorSum<=limit) {
//                res = i;
//                break;
//            }
//        }
//        return res;
//    }

//Optimal solution
    public int findTheSmallestDivisor(int[] nums, int limit) {
        int res = -1;
        if (nums.length > limit) return -1; //Watch out for this line
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]>max) {
                max = nums[i];
            }
        }
        int low = 1;
        int high = max;
        while(low<=high) {
            int mid = low+((high-low)/2);
            int quotientSum = 0;
            for(int i = 0; i<nums.length; i++) {
                double quotient = (double) nums[i]/(double) mid;
                quotientSum+=(int) Math.ceil(quotient);
            }
            if(quotientSum<=limit) {
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

        int[] arr = {8, 4, 2, 3};
        int limit = 4;
        Solution s = new Solution();
        int res = s.findTheSmallestDivisor(arr, limit);
        System.out.println("The smallest divisor is: "+res);

    }
}

//Time complexity: O(log max * n)
//Space complexity: O(1)
