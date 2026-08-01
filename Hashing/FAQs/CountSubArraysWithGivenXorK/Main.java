package Hashing.FAQs.CountSubArraysWithGivenXorK;

import java.util.HashMap;
import java.util.Map;

class Solution {
//Brute-force solution
//Time complexity: O(n^2)
//Space complexity: O(1)
//Note: This solution will give the TLE-error.
//    public int countSubArraysWithGivenXorK(int[] nums, int k) {
//        int subArrays = 0;
//        for(int i = 0; i<nums.length; i++) {
//            int xorValue = 0;
//            for(int j = i; j<nums.length; j++) {
//                xorValue = xorValue^nums[j];
//                if(xorValue==k) {
//                    subArrays++;
//                }
//            }
//        }
//        return subArrays;
//    }

//Optimal solution
    public int countSubArraysWithGivenXorK(int[] nums, int k) {
        int subArrays = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //To handle the edge case: if the current xor value is equal to k (xor==k), then remainingXorValue = xor^k = 0, for which '(0,1)' is inserted in the map at first.
        for(int i = 0; i< nums.length; i++) {
            xor = xor^nums[i];
            int remainingXorValue = xor^k;
            if(map.containsKey(remainingXorValue)) {
                subArrays+=map.get(remainingXorValue);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return subArrays;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        Solution s = new Solution();
        int res = s.countSubArraysWithGivenXorK(arr, k);
        System.out.println("The sub-arrays whose xor value "+k+" is: "+res);

    }
}

//Time complexity: O(n * logn) (logn cause of the HashMap)
//Space complexity: O(n)

//Note:
//The intuition is to iterate through the array, and check for the value: 'xor^k'
//If there is a value present in the array as 'xor^k' value, then we know that, there is a sub-array whose xor value is k.
//So we add it to the map with a count of 1.
//Then we keep checking, and if we again encounter the same value as 'xor^k', then we increase the count present in the 'value' part of the map, where 'xor' acts as a key.
//And if we encounter some different value of 'xor^k', then we simply add a new 'key: value'(xor: count=1) of that 'xor^k'.

//So the overall idea is, we add all the xor values to the map, with respective counter, and if we find a value of xor present in the map matching with 'xor^k', we add the 'value' of the respective 'xor'(key) from the map to the totalSubArraysCount.
