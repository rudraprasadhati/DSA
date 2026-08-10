package BinarySearch.LogicBuilding.FindMinimumInRotatedSortedArray;

class Solution {
//Brute force solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int findMinimumInRotatedSortedArray(int[] nums) {
//        int res = Integer.MAX_VALUE;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]<res) {
//                res = nums[i];
//            }
//        }
//        return res;
//    }

//Optimal solution
    public int findMinimumInRotatedSortedArray(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = low+((high-low)/2);
            //This condition checks that, if our total search space is sorted, then we can get the minimum element at the lowest index.
            if(nums[low]<=nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }
            if(nums[low]<=nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid+1;
            }
            else {
                min = Math.min(min, nums[mid]);;
                high = mid-1;
            }
        }
        return min;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        Solution s = new Solution();
        int res = s.findMinimumInRotatedSortedArray(arr);
        System.out.println("The minimum element int the array is: "+res);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//Note:
//We just check that which side of the array is sorted, and then store the minimum element inside a variable and then chekc further by reducing our search space accordingly.
