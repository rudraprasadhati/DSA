package arrays.fundamentals.secondLargestElement;

import java.util.Arrays;

class Solution {
    public int secondLargestElement(int[] a) {
        Arrays.sort(a);
        int largest = a[a.length-1];
        for(int i = a.length-2; i>=0; i--) {
            if(a[i] != largest) {
                return a[i];
            }
        }
        //the above loop is for the condition that if the largest element is present more than 1 times in the array, then it move further checking for the second-largest element in the array
        return -1; //if there is no second-largest element present in the array then it will return "-1"
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, 56, 78, 90, 7, 5, 56};
        Solution s = new Solution();
        int result = s.secondLargestElement(arr);
        if(result == -1) {
            System.out.println("There is no 2nd largest element present in the array.");
        }
        else{
            System.out.println("The second largest element is: "+result);
        }
    }
}

//Time Complexity: O(n logn + n)