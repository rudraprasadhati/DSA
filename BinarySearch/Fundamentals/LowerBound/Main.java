package BinarySearch.Fundamentals.LowerBound;

class Solution {
//Brute force solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int lowerBound(int[] nums, int target) {
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]>=target) {
//                return i;
//            }
//        }
//        return nums.length;
//    }

//Optimal solution
    public int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int res = nums.length;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]>=target) {
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

        int[] arr = {1, 2, 2, 3};
        int target = 2;
        Solution s = new Solution();
        int res = s.lowerBound(arr, target);
        System.out.println("The lower bound is: "+res);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//Note for the question:
//We iterate through the array, and if we encounter someone which is greater than or equal to the target, then we store its index value in the variable 'res', as it could be our possible answer, and then we just reduce our higher side bounds and update the variable 'high' to 'mid-1'.
//If it is smaller than the target, we should not even consider it, we just update our 'low' to 'mid+1', and move ahead to look for someone who is greater than or equal to the target.
//Remember, we only update our 'res' variable if and only if 'nums[mid' is greater than or eqaul to the target.

//Note regarding binary-search: If the array is sorted, and we have to search for something, then we use the binary-search algorithm.
