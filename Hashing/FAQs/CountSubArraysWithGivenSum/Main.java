package Hashing.FAQs.CountSubArraysWithGivenSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
//Brute force solution
//There is also another brute-force solution whose time complexity is O(n^3) and it uses 3 nested loops, but that solution is more complicated than this.
//The below solution is actually a better solution, if you consider the solution which uses O(n^3) time complexity as the brute-force solution.
//But the below solution is more intuitive.
//Time complexity: O(n^2)
//Space complexity: O(1)
//This solution will give the TLE-error.
//    public int countSubArraysWithGivenSum(int[] nums, int k) {
//        int maxSubArrays = 0;
//        for(int i = 0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j = i; j<nums.length; j++) {
//                sum+=nums[j];
//                if(sum==k) {
//                    maxSubArrays++;
//                }
//            }
//        }
//        return maxSubArrays;
//    }

//Optimal solution
    public int countSubArraysWithGivenSum(int[] nums, int k) {
        int totalSubArrays = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            sum+=nums[i];
            if(sum==k) {
                totalSubArrays++;
            }
            if(map.containsKey(sum-k)) {
                totalSubArrays+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return totalSubArrays;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1};
        int sum = 2;
        Solution s = new Solution();
        int res = s.countSubArraysWithGivenSum(arr, sum);
        System.out.println("The total sub-arrays with sum "+sum+" is/are: "+res);

    }
}

//Time complexity: O(n + n logn)
//Space complexity: O(n)

//Note:
//Pattern used: PrefixSum + HashMap
//(Problem might be a bit tricky, try to go through the code with cool mind)
