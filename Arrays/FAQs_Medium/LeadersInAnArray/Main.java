package Arrays.FAQs_Medium.LeadersInAnArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
//Brute force solution
//Time complexity: O(n^2)
//Space complexity: O(n) (list which is used for returning the answer)
//Auxiliary space: O(1)
//    public List<Integer> leadersInAnArray(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i<nums.length; i++) {
//            boolean flag = false;
//            for(int j = i+1; j<nums.length; j++) {
//                if(nums[i]<=nums[j]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag) {
//                list.add(nums[i]);
//            }
//        }
//        return list;
//    }

//Optimal solution
    public List<Integer> leadersInAnArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = nums.length-1; i>=0; i--) {
            if(nums[i]>max) {
                max = nums[i];
                list.add(nums[i]);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 10, 3, 4, 0, 1};
        Solution s = new Solution();
        List<Integer> list = s.leadersInAnArray(arr);
        for(int i: list) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time Complexity: O(n) + O(k)(time complexity of reverse function) where k is the number of leaders.
//Worst case: k = n, so O(n) + O(n) = O(2n) = O(n)
//Space complexity: O(n) (list which is used for returning the answer)
//Auxiliary space: O(1)

//Note: In the optimal solution, we simply traverse through the array from the last, and keep track of the maximum element as we go backwards.
//If we encounter an element which is greater than the current element, that means that greater element is greater than all the elements present to its right side, so we simply add it to our list which contain all the leaders.
//At last, we reverse the list containing all our leaders, as our question demands to return the leaders in the same order as of the original array.
