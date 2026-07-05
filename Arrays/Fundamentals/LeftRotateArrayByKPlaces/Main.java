package Arrays.Fundamentals.LeftRotateArrayByKPlaces;

import java.util.Arrays;
import java.util.Collections;

class Solution {
//My approach
//Time complexity: O(kn)
//The while-loop will take a time of O(k) and the for-loop will take a time of O(n).
//This method works but it has a time complexity of O(nk) and a space complexity of O(1).
//We can have a better approach by reducing the time complexity which can be achieved by using some extra space.
//The better approach is the code below which is not commented.
//    public void leftRotateArrayByKPlaces(int[] nums, int k) {
//        if(nums.length<2) {
//            return;
//        }
//        k = k%nums.length;
//        while(k>0) {
//            int firstElement = nums[0];
//            for(int i = 1; i<nums.length; i++) {
//                nums[i-1] = nums[i];
//            }
//            nums[nums.length-1] = firstElement;
//            k--;
//        }
//    }

//Brute force solution
//Time complexity: O(k) time for storing the elements in an extra array that are to be rotated, then O(n-k) time for shifting the remaining elements to the left, and finally O(k) time for restoring the elements that are to be rotated from the extra array to the original array.
//So, the time complexity becomes:
//O(k)+O(n-k)+O(k)
//= O(k+n-k+k)
//= O(n+k)
//= O(n+n-1) (because, as k<n, in worst case, the value of k would be nums.length-1)
//= O(n+n)
//= O(2n)
//= O(n)
//Over time complexity: O(n)
//Space complexity: O(k) (Number of elements that are to be rotated to the end of the array)
//    public void leftRotateArrayByKPlaces(int[] nums, int k) {
//        if(nums.length<2) {
//            return;
//        }
//        k = k%nums.length; //This will reduce the number of duplicated iterations.
//        int[] rotatedNums = new int[k];
//        for(int i = 0; i<k; i++) {
//            rotatedNums[i] = nums[i];
//        }
//        for(int i = k; i<nums.length; i++) {
//            nums[i-k] = nums[i];
//        }
//        int j = 0;
//        for(int i = nums.length-k; i<nums.length; i++) {
//            nums[i] = rotatedNums[j];
//            j++;
//        }
//    }

//Optimal solution
    public void leftRotateArrayByKPlaces(int[] nums, int k) {
        if(nums.length<2) {
            return;
        }
        k = k%nums.length;
        reverse(nums, 0, k-1); //We first reverse the original array from the start till 'k'th index, as it also represent how many elements we have to rotate.
        reverse(nums, k, nums.length-1); //Then we reverse the remaining elements, which should be shifted left.
        reverse(nums, 0, nums.length-1); //At last, we reverse the whole array.
    }
    private void reverse(int[] nums, int startIndex, int endIndex) {
        while(startIndex<endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 3, 1};
        int k = 3;
        Solution s = new Solution();
        s.leftRotateArrayByKPlaces(arr, k);
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(k)+O(n-k)+O(n) = O(n)+O(n) = O(2n) = O(n)
//Space complexity: O(1)

//Note:
//Critical zone:
//Remember to optimize the number of rotations by the formula, number of rotations(k) = number of rotations(k) % length of the array(n)
//Take a look on the part where we have to do the 3 reversals. (Be careful with the indexes)
