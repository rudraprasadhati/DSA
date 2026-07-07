package Arrays.LogicBuilding.IntersectionOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

class Solution {
//Brute force solution
//Time complexity: O(n1*n2)
//Time taken to store the elements from the list to an array which is used to return the answer: O(min(n1, n2))
//Space complexity: O(n2) + O(min(n1, n2)) = O(n2) (auxiliary space)
//To return the answer we use a space of: O(min(n1, n2))
//    public int[] intersectionOfTwoSortedArrays(int[] nums1, int[] nums2) {
//        int[] hashArr = new int[nums2.length];
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i<nums1.length; i++) {
//            for(int j = 0; j<nums2.length; j++) {
//                if(nums1[i]==nums2[j] && hashArr[j]==0) {
//                    list.add(nums1[i]);
//                    hashArr[j] = 1;
//                    break;
//                }
//                else if(nums1[i]<nums2[j]) {
//                    break;
//                }
//            }
//        }
//        int[] res = new int[list.size()];
//        for(int i = 0; i<list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }

//Optimal solution
    public int[] intersectionOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]==nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }
        int[] res = new int[list.size()];
        for(int k = 0; k <list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
 }
public class Main {
    public static void main(String[] args) {

        int[] arr1 = {1, 1, 3, 4, 5 , 6, 6, 6};
        int[] arr2 = {1, 2, 3, 4, 5, 5, 6, 6};
        Solution s = new Solution();
        int[] res = s.intersectionOfTwoSortedArrays(arr1, arr2);
        for(int i: res) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Auxiliary time and space complexities:
//Time complexity: O(n1+n2)
//Space complexity: O(min(n1, n2))
//You can analyse the output time and space complexities by yourself.
