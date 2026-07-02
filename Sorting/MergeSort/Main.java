package Sorting.MergeSort;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private void merge(int left, int mid, int right, int[] nums) {
        int i = left;
        int j = mid+1;
        List<Integer> list = new ArrayList<>();
        while(i<=mid && j<=right) {
            if(nums[i]<=nums[j]) {
                list.add(nums[i]);
                i++;
            }
            else {
                list.add(nums[j]);
                j++;
            }
        }
        while(i<=mid) {
            list.add(nums[i]);
            i++;
        }
        while(j<=right) {
            list.add(nums[j]);
            j++;
        }
        for(int k = left; k<=right; k++) {
            nums[k] = list.get(k-left);
        }
    }
    private void mergeSortHelper(int left, int right, int[] nums) {
        if(left>=right) {
            return;
        }
        int mid = (left+right)/2;
        mergeSortHelper(left, mid, nums);
        mergeSortHelper(mid+1, right, nums);
        merge(left, mid, right, nums);
    }
    public int[] mergeSort(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        mergeSortHelper(left, right, nums);
        return nums;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 1, 3};
        Solution s = new Solution();
        int[] res = s.mergeSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}

//Time Complexity: O(n logn) (logn for dividing the array constantly by half and n for comparing each element and sorting them up in the merging step)
//Space Complexity: O(n) (the extra arraylist used for merging)
//Note:
//Merge sort: In this sorting algorithm, we constantly divide the array into two halves until we are left with a single element. After that, we backtrack by sorting the two halves we got at each iteration and merging them up until we get our final sorted array.
//Critical zone: Look out for the step where you map the elements from the arraylist to the actual array in the last step of the merge function.
