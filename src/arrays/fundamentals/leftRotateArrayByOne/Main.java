package arrays.fundamentals.leftRotateArrayByOne;

class Solution {
    public void leftRotateArrayByOne(int[] a) {
        int temp = a[0];
        for(int i = 1; i<a.length; i++) {
            a[i-1] = a[i];
        }
        a[a.length-1] = temp;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Current array: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Solution s = new Solution();
        s.leftRotateArrayByOne(arr);
        System.out.println("After rotating: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

//Time Complexity = O(n)