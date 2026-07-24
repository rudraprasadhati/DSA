package Arrays.FAQs_Hard.MajorityElementTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
//Brute force solution
//Time complexity: O(n^2)
//Space complexity: O(1) (auxiliary space)
//    public List<Integer> majorityElementTwo(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        int listIndex = -1;
//        for(int i = 0; i<nums.length; i++) {
//            if(res.isEmpty() || nums[i]!=res.get(listIndex)) {
//                int count = 0;
//                for (int j = 0; j < nums.length; j++) {
//                    if (nums[i] == nums[j]) {
//                        count++;
//                    }
//                }
//                if (count > Math.floorDiv(nums.length, 3)) {
//                    res.add(nums[i]);
//                    listIndex++;
//                }
//                //Because in an array, the number of elements that can be greater than 'nums.length/3' is 2.
//                if(res.size()==2) {
//                    break;
//                }
//            }
//        }
//        return res;
//    }

//Better solution
//Time complexity: O(n*logn) = O(n)
//Space complexity: O(n) (auxiliary space)
//    public List<Integer> majorityElementTwo(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        Map<Integer, Integer> map = new TreeMap<>();
//        for(int i = 0; i<nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
//            //We have to check the number of occurences exactly because, if we would have checked for something like 'map.get(nums[i])>Math.floorDiv(nums.length, 3)', then it would have add the same element multiple times in the list.
//            if(map.get(nums[i])==Math.floorDiv(nums.length, 3)+1) {
//                res.add(nums[i]);
//            }
//            if(res.size()==2) {
//                break;
//            }
//        }
//        return res;
//    }

//Optimal solution
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            if(count1==0 && element2!=nums[i]) {
                element1 = nums[i];
                count1 = 1;
            }
            else if(count2==0 && element1!=nums[i]) {
                element2 = nums[i];
                count2 = 1;
            }
            else if(nums[i]==element1) {
                count1++;
            }
            else if(nums[i]==element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        int frequencyOfElemenetOne = 0;
        int frequencyOfElemenetTwo = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]==element1) {
                frequencyOfElemenetOne++;
            }
            else if(nums[i]==element2) {
                frequencyOfElemenetTwo++;
            }
        }
        if(frequencyOfElemenetOne>nums.length/3) {
            res.add(element1);
        }
        if(frequencyOfElemenetTwo>nums.length/3) {
            res.add(element2);
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 1, 3, 2, 2};
        Solution s = new Solution();
        List<Integer> res = s.majorityElementTwo(arr);
        for(int i: res) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n+n) = O(2n) = O(n)
//Space complexity: O(1)

//Note: The intuition behind the optimal solution is similar to the problem of majority-element-one, whose optimal solution uses the Boyer Moore's majority vote algorithm.
//This question require us to handle certain extra edges cases compared to the majority-element-one question to get the answer correctly.
//To identify the edge cases, try to dry run the following example: [2, 1, 1, 3, 1, 4, 5, 6]
