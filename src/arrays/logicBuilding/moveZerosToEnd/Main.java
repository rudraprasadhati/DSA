package arrays.logicBuilding.moveZerosToEnd;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void moveZerosToEnd(int[] a) {
        int j = -1;
        for(int i = 0; i<a.length; i++) {
            if(a[i] == 0) {
                j = i;
                break;
            }
        }
        for(int i = j+1; i<a.length; i++) {
            //if no zeros are present in the array, the value of "j" would still be -1, therefore the loop will break
            if(j == -1) {
                break;
            }
            if(a[i] != 0) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j++;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 0, 8, 0, 9, 4, 0, 0, 5, 3};
        System.out.println("Default elements: ");
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        Solution s = new Solution();
        s.moveZerosToEnd(arr);
        System.out.println("After moving zeros to the end: ");
        for(int i: arr) {
            System.out.print(i+ " ");
        }
    }
}

//The above method implemented is the optimised method
//Time Complexity: O(x) + O(n-x) = O(n)
//The above time complexity is slightly better than the brute force method as the brute force method is using the time complexity of O(2n)
//Space Complexity: No extra space is being used here: O(1)



//Brute force method:

//class Solution {
//    public void moveZerosToEnd(int[] a) {
//        int count = -1;
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i<a.length; i++) {
//            if(a[i] != 0) {
//                list.add(a[i]);
//                count++;
//            }
//        }
//        for(int i = 0; i<a.length; i++) {
//            if(i<=count) {
//                a[i] = list.get(i);
//            }
//            else {
//                a[i] = 0;
//            }
//        }
//    }
//}

//Time Complexity of brute force method: O(2n) = O(n)
//Space Complexity: The extra array or list taken to store the non-zero elements