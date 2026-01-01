package arrays.logicBuilding.intersectionOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int length1 = arr1.length;
        int length2 = arr2.length;
        List<Integer> temp = new ArrayList<>();
        while(i<length1 && j<length2) {
            if(arr1[i]<arr2[j]) {
                i++;
            }
            else if(arr1[i]>arr2[j]) {
                j++;
            }
            else {
                temp.add(arr1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[temp.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = temp.get(k);
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 3, 4, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 4, 5, 6, 7};
        Solution s = new Solution();
        int[] result = s.intersection(arr1, arr2);
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

//Time Complexity: O(n1*n2) //to iterate both the arrays
//Space Complexity: O(1) //here we are using no extra space, the extra array we are using is for storing the answer



//Brute force method:

//class Solution {
//    public int[] intersection(int[] arr1, int[] arr2) {
//        int length1 = arr1.length;
//        int length2 = arr2.length;
//        int[] visited = new int[arr2.length];
//        List<Integer> temp = new ArrayList<>();
//        for(int i = 0; i<length1; i++) {
//            for(int j = 0; j<length2; j++) {
//                if(arr1[i]==arr2[j] && visited[j]==0) {
//                    temp.add(arr1[i]);
//                    visited[j] = 1;
//                    break;
//                }
//                if(arr1[i]<arr2[j]) {
//                    break;
//                }
//            }
//        }
//        int[] result = new int[temp.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = temp.get(i);
//        }
//        return result;
//    }
//}

//Brute force method:
//Time Complexity: O(n1*n2) //to iterate both the arrays
//Space Complexity: O(n2) //for creating the visiting array