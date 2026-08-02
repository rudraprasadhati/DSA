package BinarySearch.Fundamentals.SearchXInSortedArray;

class Solution {
//Iterative solution
//    public int binarySearch(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length-1;
//        while(low<=high) {
//            int mid = (low+high)/2;
//            if(nums[mid]==target) {
//                return mid;
//            }
//            else if(nums[mid]>target) {
//                high = mid-1;
//            }
//            else {
//                low = mid+1;
//            }
//        }
//        return -1;
//    }

//Recursive solution
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int res = binarySearchHelper(low, high, nums, target);
        return res;
    }
    public int binarySearchHelper(int low, int high, int[] nums, int target) {
        if(low>high) {
            return -1;
        }
        int mid = (low+high)/2;
        if(nums[mid]==target) {
            return mid;
        }
        else if(nums[mid]>target) {
            return binarySearchHelper(low, mid-1, nums, target);
        }
        return binarySearchHelper(mid+1, high, nums, target);
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 5;
        Solution s = new Solution();
        int res = s.binarySearch(arr, target);
        if(res==-1) {
            System.out.println("The number is not present in the array.");
        }
        else {
            System.out.println("The number is present in the array on the position: "+res);
        }

    }
}

//Time complexity is same for both of the above solutions.
//Time complexity: O(log n base 2) (because we are dividing the array by 2 in each step)
//Generally all 'log n' with 'base 2' are written simply as 'log n'

//Space complexity: O(1)
