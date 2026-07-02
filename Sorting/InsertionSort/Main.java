package Sorting.InsertionSort;

class Solution {
    public int[] insertionSort(int[] nums) {
        for(int i = 1; i<nums.length; i++) {
            int j = i;
            while(j>0 && nums[j]<nums[j-1]) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
        return nums;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 1, 3};
        Solution s = new Solution();
        int[] res = s.insertionSort(arr);
        for(int i = 0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}

//Time Complexity:
//Worst case and Average case: O(n^2)
//Best case: O(n)

//Note:
//Insertion sort: Insertion sort, sorts the array by comparing the current element with its previous one, and if the order is wrong, then we swap the elements to bring them into the right order.
//In this sorting technique, the current element is inserted into its right position by comparing to its previous elements.
