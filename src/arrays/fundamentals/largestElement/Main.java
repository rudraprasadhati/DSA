package arrays.fundamentals.largestElement;

import java.util.Arrays;

class Solution {
    public int largestElement(int[] a) {
        Arrays.sort(a); //"Arrays.sort" uses quick sort inside internally which gives the time complexity of O(n logn)
        return a[a.length-1];  //we are sorting the array and returning the last element because after sorting the largest element would be present at the last index of the array
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {45, 34, 99, 89, 71, 32};
        Solution s = new Solution();
        int result = s.largestElement(arr);
        System.out.println("The largest element is: "+result);
    }
}

//Time Complexity: O(n logn)