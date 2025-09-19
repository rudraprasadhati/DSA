package arrays.logicBuilding.removeDuplicatesFromSortedArray;

import java.util.*;

class Solution {
    public int removeDuplicates(int[] a) {
        int i = 0;
        for(int j = 1; j<a.length; j++) {
            if(a[i]!=a[j]) {
                a[i+1] = a[j];
                i++;
            }
        }
        return i+1;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3, 4, 4, 4};
        System.out.println("Elements in the array are: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Solution s = new Solution();
        int index = s.removeDuplicates(arr);
        System.out.println("Elements after removing duplicates: ");
        for(int i = 0; i<index; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

//The above method implemented is the optimal method.
//Time Complexity of the optimal method: O(n)
//Space Complexity of the optimal method: O(1)



//Brute Force Method:

//class Solution {
//    public int removeDuplicates(int[] a) {
//        Set<Integer> s = new TreeSet<>();
//        for(int i: a) {
//            s.add(i);
//        }
//        int index = 0;
//        for(int i: s) {
//            a[index++] = i;
//        }
//        return index;
//    }
//}

//Time Complexity of brute force method: n to iterate through the array, log(n) to insert the unique elements. Then n for iterating through the array to display unique elements only.
//Final Time Complexity of brute force method: nlog(n) + n
//Space Complexity of brute force method: the set declared to store the unique elements.