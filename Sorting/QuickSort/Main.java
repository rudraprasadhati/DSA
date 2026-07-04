package Sorting.QuickSort;

class Solution {
    private int partitionFunction(int left, int right, int[] nums) {
        int pivot = nums[left];
        int i = left; //We are starting from the "i" from the pivot position itself because as we are using the Hoare's partiton scheme, so this ensures that our variables "i" and "j" cross each other at the right place, and out "j" variable stop at the right place, which is to be swapped with the pivot.
        int j = right;
        while(i<j) {
            //Here we iterate and move the "i" pointer forward until we find the correct element on the left side which is greater than the pivot.
            //"i<=right-1", this line ensures that, we don't go out of the right most index and re-enter the while loop, which would give us an index-out-of-bounds error.
            while(pivot>=nums[i] && i<=right-1) {
                i++;
            }
            //Here we iterate and move the "j" pointer backward until we find the correct element on the right side which is smaller than or equal to the pivot.
            //"j>=left+1", this line ensures that, we don't go out of the left most index and re-enter the while loop, which would give us an index-out-of-bounds error.
            while(pivot<nums[j] && j>=left+1) {
                j--;
            }
            //Until we reach this portion of the loop, out pointers should be at the correct elements which are eligible for swapping.
            //So, here we make a last check that, if our pointers have not crossed each other till now, swap the candidates present at the pointer's location.
            if(i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        //At last, until this point, our pointers would have crossed each other, and j should be pointing to the last element of the left side which either smaller or equal to the pivot, so we swap them.
        nums[left] = nums[j];
        nums[j] = pivot;
        return j;
    }
    private void quickSortHelper(int left, int right, int[] nums) {
        if(left>=right) {
            return;
        }
        int partition = partitionFunction(left, right, nums);
        quickSortHelper(left, partition-1, nums);
        quickSortHelper(partition+1, right, nums);
    }
    public int[] quickSort(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        quickSortHelper(left, right, nums);
        return nums;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 3, 1};
        Solution s = new Solution();
        int[] res = s.quickSort(arr);
        for(int i = 0; i< res.length; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}

//Time Complexity: O(n logn)
//It is considered better than merge-sort because it doesn't take any extra space to while merging the elements.

//Note:
//Quick sort: This sorting algorithm divides the array into two parts by choosing an element as pivot, and uses the pivot element to form a partition, where the left half contains elements smaller than or equal to the pivot, and the right half contains elements greater than the pivot.
//It then recursively perform this operation on both the halves, to sort the entire array.
//Critical zone: Make sure you understand the partition algorithm well.
//We have used the Hoare's partition algorithm in our quick sort implementation.
//There is also another partition algorithm called as Lomuto partition scheme. You can also use it in the partition function, but it is generally slower in some cases compared to the Hoare's partition scheme.
