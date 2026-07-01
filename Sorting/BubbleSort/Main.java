package Sorting.BubbleSort;

class Solution {
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = false;
            for(int j = 0; j<nums.length-1; j++) {
                if(nums[j]>nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
        return nums;
    }
}
public class Main {
    public static void main(String[] args) {
        
        int[] arr = {4, 5, 6, 3, 1, 2};
        Solution s = new Solution();
        int[] res = s.bubbleSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();
        
    }
}

//Time Complexity:
//Worst case and Average case: O(n^2)
//Best Case: O(n), if all the elements are in the right order, it iterates for only 1 time.

//Note:
//Bubble Sort: Bubble sort, sorts element in increasing order(here), by comparing the adjacent elements and swapping them if they are in the wrong order.
//With each iteration, the largest element goes to the end of the array, so the sorting happens from the last of the array.
