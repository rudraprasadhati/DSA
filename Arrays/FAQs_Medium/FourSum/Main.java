package Arrays.FAQs_Medium.FourSum;

import java.util.*;

class Solution {
//Brute force solution
//The brute force solution is very much time demanding, so it will give an error of time-limit exceeded.
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        for(int i = 0; i<nums.length; i++) {
//            for(int j = i+1; j<nums.length; j++) {
//                for(int k = j+1; k<nums.length; k++) {
//                    for(int l = k+1; l<nums.length; l++) {
//                        long sum = nums[i];
//                        sum+=nums[j];
//                        sum+=nums[k];
//                        sum+=nums[l];
//                        if(sum==target) {
//                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                            Collections.sort(temp);
//                            if(!res.contains(temp)) {
//                                res.add(temp);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

//Better solution
//Time complexity: O(n^3)
//Space complexity: O(n) (auxiliary space)
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Set<List<Integer>> res = new HashSet<>();
//        for(int i = 0; i<nums.length; i++) {
//            for(int j = i+1; j<nums.length; j++) {
//                Set<Long> set = new HashSet<>();
//                for(int k = j+1; k<nums.length; k++) {
//                    long sum = nums[i];
//                        sum+=nums[j];
//                        sum+=nums[k];
//                    long fourthNumber = (long) target - sum;
//                    if(set.contains(fourthNumber)) {
//                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourthNumber);
//                        Collections.sort(temp);
//                        res.add(temp);
//                    }
//                    set.add(nums[k]);
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }

//Optimal solution
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            for(int j = i+1; j<nums.length; j++) {
                if(j!=i+1 && nums[j]==nums[j-1]) {
                    continue;
                }
                int k = j+1;
                int l = nums.length-1;
                while(k<l) {
                    long sum = nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum > target) {
                        l--;
                    }
                    else if(sum < target) {
                        k++;
                    }
                    else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        res.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) {
                            k++;
                        }
                        while(k<l && nums[l]==nums[l+1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {3, 4, 5, -6, 2, 1, -2, 9, -3, 0, 5 ,0};
        int target = 2;
        Solution s = new Solution();
        List<List<Integer>> res= s.fourSum(arr, target);
        for(List i: res) {
            System.out.println(i);
        }

    }
}

//Time complexity: O(n logn + n^3) = O(n^3)
//Space complexity: O(1) (auxiliary space)
