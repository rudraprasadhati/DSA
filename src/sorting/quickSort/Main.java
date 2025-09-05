package sorting.quickSort;

class Solution {
    private void quickSortHelper(int[] a, int low, int high) {
        if(low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int mid = low + ((high-low)/2);
        int pivot = a[mid];
        while(left<=right) {
            while(a[left]<pivot) {
                left++;
            }
            while(a[right]>pivot) {
                right--;
            }
            if(left<=right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        //here the variables "left" and "right" has crossed it other, for which we traverse from "low" to "right" and from "left" to "right"
        //remember, here the fix pointers are "low" and "high"
        quickSortHelper(a, low, right);
        quickSortHelper(a, left, high);
    }
    public int[] quickSort(int[] a) {
        int low = 0;
        int high = a.length-1;
        quickSortHelper(a, low, high);
        return a;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {7, 4, 1, 5, 3};
        System.out.println("Elements before sorting: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Solution s = new Solution();
        int[] newArr = s.quickSort(arr);
        System.out.println("Elements after sorting: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}

//Quick Sort: This sorting algorithm sorts the array by choosing a pivot element and separates the smaller elements than itself to the left side of the array and the larger elements than itself to the right side of the array while the pivot element stays in the middle.
//It then repeats this process recursively until the whole array is sorted.

//Time Complexity = O(n logn)
//Space Complexity = O(1)
//Here the space complexity is slightly better than the merge sort, for which the quick sort is preferred over merge sort.