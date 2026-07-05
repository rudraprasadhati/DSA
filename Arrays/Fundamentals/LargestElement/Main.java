package Arrays.Fundamentals.LargestElement;

import java.util.Arrays;

class Solution {
//Brute force solution
//Time complexity: O(n logn)
//    public int largestElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length-1];
//    }

//Optimal solution
    public int largestElement(int[] nums) {
        int largest = nums[0];
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]>largest) {
                largest = nums[i];
            }
        }
        return largest;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 1, 3};
        Solution s = new Solution();
        int res = s.largestElement(arr);
        System.out.println("The largest element of the array is: "+res);

    }
}

//Time complexity: O(n)
