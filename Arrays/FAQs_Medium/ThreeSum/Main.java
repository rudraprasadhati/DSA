package Arrays.FAQs_Medium.ThreeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
//Brute force solution
//The brute force solution will have an error of time-limit-exceeded, as it is using 3 nested loops and a sort function, so we should not consider this as a solution.
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        for(int i = 0; i<nums.length; i++) {
//            for(int j = i+1; j<nums.length; j++) {
//                for(int k = j+1; k<nums.length; k++) {
//                    if(nums[i]+nums[j]+nums[k]==0) {
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        Collections.sort(temp);
//                        if(!res.contains(temp)) {
//                            res.add(temp);
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }


}
public class Main {
    public static void main(String[] args) {

        int[] arr = {2, -2, 0, 3, -3, 5};
        Solution s = new Solution();
        List<List<Integer>> res = s.threeSum(arr);
        for(List i: res) {
            System.out.println(i);
        }

    }
}
