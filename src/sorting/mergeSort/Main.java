package sorting.mergeSort;

import java.util.*;

class Solution{
    public void merge(int[] a, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left <= mid && right <= high) {
            if(a[right] > a[left]) {
                temp.add(a[left]);
                left++;
            }
            else {
                temp.add(a[right]);
                right++;
            }
        }
        while(left <= mid) {
            temp.add(a[left]);
            left++;
        }
        while(right <= high) {
            temp.add(a[right]);
            right++;
        }
        for(int i = low; i<=high; i++) {
            a[i] = temp.get(i-low);
        }
    }
    public void mergeSortHelper(int[] a, int low, int high) {
        int mid = (high+low)/2;
        if(low == high) {
            return;
        }
        mergeSortHelper(a, low, mid);
        mergeSortHelper(a, mid+1, high);
        merge(a, low, mid, high);
    }
    public int[] mergeSort(int[] a) {
        int n = a.length-1;
        mergeSortHelper(a, 0, n);
        return a;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {99, 78, 34, 12, 26, 92, 100};
        System.out.println("Elements before sorting: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Solution s = new Solution();
        int[] newArr = s.mergeSort(arr);
        System.out.println("Elements after sorting: ");
        for(int i = 0; i<newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}

//Merge Sort: Merge sort follows a divide and conquer algorithm which divides the array continuously into two halves until a single element is present in each side. Then we go backwards merging the elements in a sorted order until we reach the original size of the array where we get the elements in the ascending order.
//Time Complexity(best, average, worst) = O(n logn)
//Space Complexity = O(n)