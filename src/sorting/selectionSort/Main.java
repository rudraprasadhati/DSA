package sorting.selectionSort;

class Solution {
    public int[] selectionSort(int[] a) {
        int n = a.length;
        for(int i = 0; i<a.length-1; i++){
            int min = a[i];
            for(int j = i; j<a.length; j++){
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {34, 23, 17, 89, 56, 43, 45};
        System.out.println("Elements in array are: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        Solution s = new Solution();
        int[] sortedArr = s.selectionSort(arr);
        System.out.println();
        System.out.println("Elements after sorting: ");
        for(int i = 0; i<sortedArr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

//Selection Sort: Compares the current element with each element of the array and gets swapped with the next/respective minimum element of the array.
//Sorting happens from first to last.
//Time Complexity(best, average, worst) = O(n^2)