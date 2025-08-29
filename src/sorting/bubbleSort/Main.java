package sorting.bubbleSort;

class Solution{
    public int[] bubbleSort(int[] a){
        int n = a.length;
        for(int i = n-1; i>=1; i--) {
        //outer loop indicates that how much time it should perform the function according to the number of elements present in the array
            int didSwap = 0;
            for(int j = 0; j<n-1; j++) {
            //inner loop helps to execute the function if the conditions are met
            //remember that here we are iterating till the last second element as the last element doesn't have a next element so the condition "a[j+1]" will give a run time error
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap == 0) {
                break;
            }
        }
        return a;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 23, 87, 45, 56, 90, 101, 29};
        System.out.println("Elements in the array are: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Solution s = new Solution();
        int[] newArr = s.bubbleSort(arr);
        System.out.println("Elements after sorting: ");
        for(int i = 0; i<newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}

//Bubble Sort: We compare every two adjacent element and swaps them if they are in descending order.
//Sorting happens from last to first.
/*
Time Complexity:
best: O(n) //If the elements are in the ascending order from the first iteration then we don't have to proceed. (make sure to write the extra condition for this optimization)
worst: O(n^2)
*/