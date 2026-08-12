package BinarySearch.LogicBuilding.FindOutHowManyTimesTheArrayIsRotated;

import java.util.ArrayList;
import java.util.List;

class Solution {
//Brute force solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int findOutHowManyTimesTheArrayIsRotated(int[] nums) {
//        int res = 0;
//        if(nums.length>1) {
//            for (int i = 0; i<nums.length-1; i++) {
//                if (nums[i]>nums[i+1]) {
//                    res = i+1;
//                }
//            }
//        }
//        return res;
//    }

//Optimal solution
    public int findOutHowManyTimesTheArrayIsRotated(ArrayList<Integer> nums) {
        int low = 0;
        int high = nums.size()-1;
        while(low<=high) {
            if(nums.get(low)<=nums.get(high)) {
                return low;
            }
            int mid = low+((high-low)/2);
            if(nums.get(low)<=nums.get(mid)) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(4, 5, 6, 7, 0, 1, 2, 3));
        Solution s = new Solution();
        int res = s.findOutHowManyTimesTheArrayIsRotated(arr);
        System.out.println("The array is rotated "+res+" times.");

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//Note: Here we just have to find the index of the smallest number to get how many times the array has been rotated.

//You can also try a similar question by yourself in which, there are duplicate numbers in the array.
