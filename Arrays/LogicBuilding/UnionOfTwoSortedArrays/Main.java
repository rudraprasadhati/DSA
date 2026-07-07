package Arrays.LogicBuilding.UnionOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

class Solution {
//Brute force solution
//Time complexity: O(n1 logn) + O(n2 logn) + O(n1+n2)(used for storing the values from the tree-set to array, which will be used for returning from the function)
//Space complexity: O(n1+n2) + O(n1+n2)(used for returning the array from the function)
//    public int[] unionOfTwoSortedArrays(int[] nums1, int[] nums2) {
//        Set<Integer> set = new TreeSet<>();
//        for(int i = 0; i<nums1.length; i++) {
//            set.add(nums1[i]);
//        }
//        for(int i = 0; i<nums2.length; i++) {
//            set.add(nums2[i]);
//        }
//        int[] res = new int[set.size()];
//        int j = 0;
//        for(int i: set) {
//            res[j] = i;
//            j++;
//        }
//        return res;
//    }

//Optimal solution
    public int[] unionOfTwoSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]<=nums2[j]) {
                if(list.isEmpty() || list.get(list.size()-1)!=nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
            }
            else {
                if(list.isEmpty() || list.get(list.size()-1)!=nums2[j]) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }
        while(i<nums1.length) {
            if (list.isEmpty() || list.get(list.size()-1)!=nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }
        while(j<nums2.length) {
            if(list.isEmpty() || list.get(list.size()-1)!=nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
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

        int[] arr1 = {1, 2, 3, 3, 4, 5};
        int[] arr2 = {3, 5, 6, 6, 7};
        Solution s = new Solution();
        int[] res = s.unionOfTwoSortedArrays(arr1, arr2);
        for(int i: res) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n1+n2)
//Space complexity: O(n1+n2) + O(n1+n2)(This space is taken by the array to return the answer)
//Overall space complexity: O(n1+n2)
//Critical zone: Be careful while managing the indexes of the two pointers "i" and "j".
