package Arrays.FAQs_Medium.ThreeSum;

import java.util.*;

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

//Better solution
//Time complexity: O(n^2)
//Space complexity: O(2k + n) (output space) (here 'k' is the number of unique triplets, which is stored inside the Hash-set and List)
//Auxiliary space: O(n)
//    public List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> res = new HashSet<>();
//        for(int i = 0; i<nums.length; i++) {
//            Set<Integer> set = new HashSet<>(); //We declare the set inside the first loop because, we want to make our set empty before we reset our first element. This ensures that there are no duplicate elements added to the list.
//            for(int j = i+1; j<nums.length; j++) {
//                int thirdNumber = -(nums[i]+nums[j]);
//                if(set.contains(thirdNumber)) {
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[i]);
//                    temp.add(nums[j]);
//                    temp.add(thirdNumber);
//                    Collections.sort(temp);
//                    res.add(temp);
//                }
//                set.add(nums[j]);
//            }
//        }
//        return new ArrayList<>(res);
//    }

//Optimal solution
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                if(nums[i]+nums[j]+nums[k]>0) {
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0) {
                    j++;
                }
                else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while(nums[j]==nums[j-1] && j<k) {
                        j++;
                    }
                    while(nums[k]==nums[k+1] && j<k) {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {-3,0,0,3,3};
        Solution s = new Solution();
        List<List<Integer>> res = s.threeSum(arr);
        for(List i: res) {
            System.out.println(i);
        }

    }
}

//Time complexity: O(n logn + n^2)
//Space complexity: O(1) (auxiliary space)
//Output space: O(k)
