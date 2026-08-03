package BinarySearch.LogicBuilding.SearchInsertPosition;

class Solution {
//Brute force solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int searchInsertPosition(int[] nums, int target) {
//        int res = nums.length;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]>=target) {
//                res = i;
//                break;
//            }
//        }
//        return res;
//    }

//Optimal solution
    public int searchInsertPosition(int[] nums, int target) {
        int res = nums.length;
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]==target) {
                res = mid;
                break;
            }
            else if(nums[mid]>target) {
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

        int[] arr = {1, 3, 5, 6};
        int target = 5;
        Solution s = new Solution();
        int res = s.searchInsertPosition(arr, target);
        System.out.println("The correct position is: "+res);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//Note: This question is similar to lower bound.
