package Arrays.FAQs_Medium.RearrangeArrayElementsBySign;

import java.util.ArrayList;
import java.util.List;

class Solution {
//Brute force solution
//Time complexity: O(n) + O(n/2) = O(2n) = O(n)
//Space complexity: O(n/2) + O(n/2) = O(n)
//    public int[] rearrangeArrayElementsBySign(int[] nums) {
//        int n = nums.length;
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]>0) {
//                list1.add(nums[i]);
//            }
//            else {
//                list2.add(nums[i]);
//            }
//        }
//        for(int i = 0; i<n/2; i++) {
//            nums[i*2] = list1.get(i);
//            nums[(i*2)+1] = list2.get(i);
//        }
//        return nums;
//    }

//Optimal solution
    public int[] rearrangeArrayElementsBySign(int[] nums) {
        int[] res = new int[nums.length];
        int positiveElementsPointer = 0;
        int negativeElementsPointer = 1;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]>0) {
                res[positiveElementsPointer] = nums[i];
                positiveElementsPointer+=2;
            }
            else {
                res[negativeElementsPointer] = nums[i];
                negativeElementsPointer+=2;
            }
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 4, 4, -4, -6, -10, 9, -1};
        Solution s = new Solution();
        int[] res = s.rearrangeArrayElementsBySign(arr);
        for(int i: res) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n)
//Space complexity: O(n)
//The optimal solution is slightly better than the brute force solution, as it is solving our problem with a single pass.
