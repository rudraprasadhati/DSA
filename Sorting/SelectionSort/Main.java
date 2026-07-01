package Sorting.SelectionSort;

class Solution {
    public int[] selectionSort(int[] nums) {
        for(int i = 0; i<nums.length-1; i++) {
            int min = i;
            for(int j = i+1; j<nums.length; j++) {
                if(nums[min]>nums[j]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {9, 3, 2, 6, 7, 5};
        Solution s = new Solution();
        int[] res = s.selectionSort(arr);
        for(int i = 0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}

//Time Complexity: O(n^2)

//Note:
//Selection sort, selects the minimum element(if the order is increasing) from the array and swaps with the current element.
//Sorting happens from the beginning of the array.
//The "min" variable store the minimum element's index, not the actual value.
