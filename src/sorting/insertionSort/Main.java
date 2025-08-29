package sorting.insertionSort;

class Solution {
    public int[] insertionSort(int[] a) {
        int n = a.length;
        for(int i = 1; i<n; i++) {
        //we start from index "1" so that we have two elements to compare
            int j = i;
            while(j>0 && a[j]<a[j-1]) {
            //here the condition is "j>0" not "j>=0" because it would create a runtime error as the second condition "a[j-1]" will yield the value "-1" for the index number "0"
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;

                j--;
            }
        }
        return a;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {34, 21, 45, 90, 10, 27, 7};
        System.out.println("Elements in array: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Solution s = new Solution();
        int[] sortedArr = s.insertionSort(arr);
        System.out.println("Elements after sorting: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(sortedArr[i]+" ");
        }
    }
}

//Insertion Sort: We take an element and compare with all its previous elements and if there is any element greater than the current element then we interchange their positions by swapping each element present in between them.
/*
Time Complexity:
best: O(n) //If all the elements are in sorted order.
worst: O(n^2)
*/