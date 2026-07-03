package Arrays.Fundamentals.LargestElement;

import java.util.Arrays;

class Solution {
    public int largestElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1];
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

//Time complexity: O(n logn)
