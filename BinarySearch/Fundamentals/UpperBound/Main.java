package BinarySearch.Fundamentals.UpperBound;

class Solution {
//Brute force solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int upperBound(int[] nums, int target) {
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]>target) {
//                return i;
//            }
//        }
//        return nums.length;
//    }

//Optimal solution
    public int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int res = nums.length;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]>target) {
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

        int[] arr = {3, 5, 8, 15, 19};
        int target = 14;
        Solution s = new Solution();
        int res = s.upperBound(arr, target);
        System.out.println("The upper bound is: "+res);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//Note: The logic is same as lower-bound question.
