package arrays.logicBuilding.unionOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] unionOfTwoSortedArrays(int[] a, int[] b) {
        int length1 = a.length-1;
        int length2 = b.length-1;
        int i = 0;
        int j= 0;
        List<Integer> l = new ArrayList<>();
        while(i<=length1 && j<=length2) {
            //here the current elements of both the arrays are checked for which is smaller
            if(a[i]<=b[j]) {
                //here the condition "l.isEmpty()" is checked for an empty list, if the list is empty, the element gets inserted in the list without checking further conditions //by the way this condition is only valid for the first element
                //the second condition "(l.get(l.size()-1)!=a[i])" checks the last element of the list with the current candidate, if they are not equal, the candidate gets inserted
                if(l.isEmpty() || (l.get(l.size()-1)!=a[i])) {
                    l.add(a[i]);
                }
                i++;
            }
            else {
                if(l.isEmpty() || (l.get(l.size()-1)!=b[j])) {
                    l.add(b[j]);
                }
                j++;
            }
        }
        while(i<=length1) {
            if(l.isEmpty() || (l.get(l.size()-1)!=a[i])) {
                l.add(a[i]);
            }
            i++;
        }
        while(j<=length2) {
            if(l.isEmpty() || (l.get(l.size()-1)!=b[j])) {
                l.add(b[j]);
            }
            j++;
        }
        int[] unionArray = new int[l.size()];
        int index = 0;
        for(int x: l) {
            unionArray[index++] = x;
        }
        return unionArray;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 4, 5, 6, 7};
        int[] arr2 = {2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 8};
        System.out.println("Elements in array1: ");
        for (int i: arr1) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Elements in array2: ");
        for (int i: arr2) {
            System.out.print(i+" ");
        }
        System.out.println();
        Solution s = new Solution();
        int[] result = s.unionOfTwoSortedArrays(arr1, arr2);
        System.out.println("Union of both arrays are: ");
        for(int i: result) {
            System.out.print(i+" ");
        }

    }
}

//Time Complexity of optimal method: O(m+n) //We are iterating through two arrays.
//Space Complexity of optimal method: O(m+n) //The list in which we are inserting all the elements.
//We are also using an extra array at last, but this array is used for returning the values.



//Brute force method:

//class Solution {
//    public int[] unionOfTwoSortedArrays(int[] a, int[] b) {
//        Set<Integer> set = new TreeSet<>();
//        for(int i: a) {
//            set.add(i);
//        }
//        for(int i: b) {
//            set.add(i);
//        }
//        int[] union = new int[set.size()];
//        int iterator = 0;
//        for(int i: set) {
//            union[iterator++] = i;
//        }
//        return union;
//    }
//}

//The sorting and insertion of elements in a set uses quick sort internally which takes the time complexity as O(nlogn)
//Here we are inserting elements from both the array to the set which makes the time complexity as: O(mlogn) + O(nlogn)
//After that we insert all the elements to a new array which takes the time complexity as: O(m+n)
//Total time complexity of brute force method: O(mlogn) + O(nlogn) + O(m+n)
//Space Complexity of brute force method: O(m+n) //The set in which we insert the elements
//We also use an array which return the values and takes O(m+n) space complexity but as it is used for returning the values, we will not consider it in the space complexity.