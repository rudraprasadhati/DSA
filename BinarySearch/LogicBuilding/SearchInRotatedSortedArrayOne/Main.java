package BinarySearch.LogicBuilding.SearchInRotatedSortedArrayOne;

class Solution {
//Brute force solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int searchInRotatedSortedArrayOne(int[] nums, int target) {
//        int res = -1;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]==target) {
//                return i;
//            }
//        }
//        return res;
//    }

//Optimal solution
    public int searchInRotatedSortedArrayOne(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]>=nums[low]) {
                if(nums[low]<=target && target<nums[mid]) {
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
            else {
                if(nums[mid]<target && target<=nums[high]) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Solution s = new Solution();
        int res = s.searchInRotatedSortedArrayOne(arr, target);
        System.out.println("The number "+target+" is present at the index: "+res);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//If you see the word "sorted" and "search", go for the binary search for the optimal solution.

//Note:
//The idea is to implement the binary search algorithm with certain changes to find the answer for this question.
//We first check that, if the element at the index 'mid' is equal to the target or not.
//Then, we just simply check that, if the left half is sorted or the right half is sorted.

//In this type of question, it is bound to happen that, either one of the sides out of 'left' and 'right' would be sorted, cause the array is left rotated, and if the array is left rotated, the rotated elements would have been added from the right side which is the end of the array.
//As the entry of elements are happening from the end of the array, it is obvious for the above condition to happen, i.e. either side would have been sorted.

//Now, if we find that the left half is sorted, then we just check that, if the target is lying in between the 'arr[low]' and 'arr[mid]'.
//If the target is lying in between the 'arr[low]' and 'arr[mid]', then we just omit the right part by updating our 'high' to 'high = mid-1'.
//If the target is not lying in between 'arr[low]' and 'arr[mid], we just omit the left part of the array by updating our 'left' to 'left = mid+1'.

//Similarly, if we would have found out that, our left part of the array is not sorted, then the right part of the array is definitely sorted.
//Then we would have just repeated the same process as per the right part of the array, as we discussed for the left part of the array above.
