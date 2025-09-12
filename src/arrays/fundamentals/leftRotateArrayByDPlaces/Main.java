package arrays.fundamentals.leftRotateArrayByDPlaces;

import java.util.Scanner;

class Solution {
    private void reverse(int[] a, int start, int end) {
        while(start<end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    public void leftRotateArrayByDPlaces(int[] a, int d) {
        int n = a.length;
        reverse(a, 0, d-1); //we reverse the array from "start" to "d-1"
        reverse(a, d, n-1); //then we reverse it from "d" till "end"
        reverse(a, 0, n-1); //at last, we reverse the final array to get our required answer
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Current elements: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Enter how many places you want to rotate: ");
        Scanner sc = new Scanner(System.in);
        int places = sc.nextInt();
        Solution s = new Solution();
        s.leftRotateArrayByDPlaces(arr, places);
        System.out.println("After rotating the array by "+places+" places, the elements in the array are: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

//The above method implemented is the optimised method, but it uses a slightly greater time complexity.
//It is optimised for the reason because it uses no extra space in the method.
//Time Complexity of optimised method = O(d+(n-d)+n)
//d-d gets cancelled
//Final Time Complexity of optimised method = O(2n)



//Brute Force method:

//class Solution {
//    public void leftRotateArrayByDPlaces(int[] a, int places) {
//        int n = a.length;
//        int d = places%n;
//        int[] temp = new int[d];
//        for(int i = 0; i<d; i++) {
//            temp[i] = a[i];
//        }
//        for(int i = d; i<n; i++) {
//            a[i-d] = a[i];
//        }
//        for(int i = n-d; i<n; i++) {
//            a[i] = temp[i-(n-d)];
//        }
//    }
//}

//Time Complexity of brute force method = O(n+d) = O(n)
//Space Complexity od brute force method = here we are taking a temporary array to store the elements which are to be rotated