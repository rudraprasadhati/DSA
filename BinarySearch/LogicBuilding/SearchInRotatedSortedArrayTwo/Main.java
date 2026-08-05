package BinarySearch.LogicBuilding.SearchInRotatedSortedArrayTwo;

class Solution {
//Time complexity: O(n)
//Space complexity: O(1)
//    public boolean searchInRotatedSortedArrayTwo(int[] nums, int target) {
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]==target) {
//                return true;
//            }
//        }
//        return false;
//    }

//Optimal solution
    public boolean searchInRotatedSortedArrayTwo(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]==target) {
                return true;
            }
            if(nums[low]==nums[mid] && nums[high]==nums[mid]) {
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]) {
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
        return false;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        Solution s = new Solution();
        boolean res = s.searchInRotatedSortedArrayTwo(arr, k);
        if(res) {
            System.out.println("The element is present in the array.");
        }
        else {
            System.out.println("The element is not present in the array.");
        }

    }
}

//Time complexity:
//O(log n) (average case)
//O(n/2) (worst case): if there are many duplicate elements in the array, then we have to shrink the array multiple times.
//Space complexity: O(1)

//In this question, we just need to handle the edge case for the duplicate elements, i.e., if the 'nums[low]==nums[mid] && nums[high]==nums[mid]', we just do 'low++' and 'high--', and then we just skip the current iteration.
//After that it is similar to the solution of the question: 'searchInRotatedSortedArrayOne'
