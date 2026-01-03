package arrays.FAQsMedium.leadersInAnArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Leaders in an array are the numbers who are the greatest of all the numbers of their right side.
class Solution {
    public List<Integer> leaders(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = arr.length-1; i>=0; i--) {
            if(arr[i]>max) {
                max = arr[i];
                result.add(arr[i]);
            }
        }
        Collections.reverse(result); //This statement is to reverse the resulting List to match the required output.
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 3};
        Solution s = new Solution();
        List<Integer> result = s.leaders(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n) //This is only to store the result.



//Brute force method:

//class Solution {
//    public List<Integer> leaders(int[] arr) {
//        List<Integer> result = new ArrayList<>();
//        for(int i = 0; i<arr.length; i++) {
//            boolean leader = true;
//            for(int j = i+1; j<arr.length; j++) {
//                if(arr[i]<=arr[j]) {
//                    leader = false;
//                    break;
//                }
//            }
//            if(leader) {
//                result.add(arr[i]);
//            }
//        }
//        return result;
//    }
//}

//Complexities of brute force method:
//Time Complexity: O(n**2)
//Space Complexity: O(n) //This is only to store the result.