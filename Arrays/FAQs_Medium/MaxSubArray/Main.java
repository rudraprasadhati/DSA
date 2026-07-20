package Arrays.FAQs_Medium.MaxSubArray;

class Solution {
//Brute force solution (This solution has a time limit exceeded error)
//Time complexity: O(n^3)
//Space complexity: O(1)
//Note: Dry run the iterations of the loops to understand the flow.
//    public int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i<nums.length; i++) {
//            for(int j = i; j<nums.length; j++) {
//                int sum = 0;
//                for(int k = i; k<=j; k++) {
//                    sum+=nums[k];
//                    if(sum>max) {
//                        max = sum;
//                    }
//                }
//            }
//        }
//        return max;
//    }

//Better solution
//Time complexity: O(n^2)
//Space complexity: O(1)
//    public int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j = i; j<nums.length; j++) {
//                sum+=nums[j];
//                if(sum>max) {
//                    max = sum;
//                }
//            }
//        }
//        return max;
//    }

//Optimal solution
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<nums.length; i++) {
            sum+=nums[i];
            if(sum>max) {
                max = sum;
            }
            if(sum<0) {
                sum = 0;
            }
        }
        return max;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 3, -5, 3, 10, 3, 8};
        Solution s = new Solution();
        int res = s.maxSubArray(arr);
        System.out.println("The sum of the maximum sub array is: "+res);

    }
}

//Optimal solution
//Time complexity: O(n)
//Space complexity: O(1)

//Kadane's algorithm: We iterate through the array and add every element to the 'sum' varibale and with each iteration we check that if the 'sum' variable is greater than the variable 'max', and if it true then we update our varibale 'max' as of the current 'sum' value.
//Then we add a condition to check that, if the value of 'sum' anytime goes below zero, then we reset the value of sum to zero.
