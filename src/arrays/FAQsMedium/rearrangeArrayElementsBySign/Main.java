package arrays.FAQsMedium.rearrangeArrayElementsBySign;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rearrangeElements(int[] arr) {
            int posIndex = 0;
            int negIndex = 1;
            int[] result = new int[arr.length];
            for(int i = 0; i<arr.length; i++) {
                if(arr[i]>0) {
                    result[posIndex] = arr[i];
                    posIndex+=2;
                }
                else {
                    result[negIndex] = arr[i];
                    negIndex+=2;
                }
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {-2, 1, 2, 4, -3, -8};
        Solution s = new Solution();
        int[] result = s.rearrangeElements(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)



//Brute force method:

//class Solution {
//    public int[] rearrangeElements(int[] arr) {
//        List<Integer> l1 = new ArrayList<>();
//        List<Integer> l2 = new ArrayList<>();
//        for(int i = 0; i<arr.length; i++) {
//            if(arr[i]>0) {
//                l1.add(arr[i]);
//            }
//            else {
//                l2.add(arr[i]);
//            }
//        }
//        for(int i = 0; i<arr.length/2; i++) {
//            arr[i*2] = l1.get(i);
//            arr[(i*2)+1] = l2.get(i);
//        }
//        return arr;
//    }
//}

//Complexities of brute force method:
//Time Complexity: O(n)+O(n/2)
//Space Complexity: O(n/2)+O(n/2) = O(n)