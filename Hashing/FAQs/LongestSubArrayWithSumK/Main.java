package Hashing.FAQs.LongestSubArrayWithSumK;

import java.util.HashMap;
import java.util.Map;

class Solution {
//Brute force solution
//Time complexity: O(n^2)
//Space complexity: O(1)
//    public int longestSubArrayWithSumK(int[] nums, int k) {
//        int sizeOfSubArray = 0;
//        for(int i = 0; i<nums.length; i++) {
//            int count = 0;
//            int sum = 0;
//            for(int j = i; j<nums.length; j++) {
//                sum+=nums[j];
//                count++;
//                if(sum==k && count>sizeOfSubArray) {
//                    sizeOfSubArray =count;
//                }
//            }
//        }
//        return sizeOfSubArray;
//    }

//Optimal solution
    public int longestSubArrayWithSumK(int[] nums, int k) {
        int sizeOfSubArray = 0;
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        for(int i = 0; i<nums.length; i++) {
            sum+=nums[i];
            if(sum == k) {
                sizeOfSubArray = i + 1;
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if(map.containsKey(sum-k)) {
                int count = i - map.get(sum-k);
                if(count>sizeOfSubArray) {
                    sizeOfSubArray = count;
                }
            }
        }
        return sizeOfSubArray;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {-10, 5, 2, -7, 1, 9};
        int k = 7;
        Solution s = new Solution();
        int res = s.longestSubArrayWithSumK(arr, k);
        System.out.println("The size of the longest sub-array of sum "+k+" is: "+res);

        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int k1 = 7;
        Solution1 s1 = new Solution1();
        int res1 = s1.longestSubArrayWithSumK1(arr1, k1);
        System.out.println("The size of the longest sub-array for an array of only positive integers of sum "+k1+" is: "+res1);

    }
}

//Time complexity: O(n)
//Here we have taken a hash-map, whose functions generally take O(1) time complexity, and O(n) in worst case which occurs in rare scenarios.
//So, we have assumed that the functions will take O(1)
//Space complexity: O(n)


//Note:

//At start we just add an if-condition to handle a test case, that if we find the sum to be as the target(k), then this is the maximum size of the subarray which starts from the start until the current iteration.

//After that, the main idea is to tackle the problem by using the pattern called as prefix-sum.
//Here we just iterate through the array, and add all the array's elements to a 'sum' variable, and in an additional map, we keep storing the 'sum' as the key, and the index as the value.
//Then in each iteration, we just check that, if the map previously contain a value of 'sum-k' (currentSum - target).
//If the map contains the value 'sum-k', now we are sure that, starting from the next position of that element which is equal to 'sum-k', until the current element, those elements in-between adds up to the target(k).

//Also we add if condition to check that, if a sum is already present, we don't insert it again. This will help us to handle the case of zeros.
//For example: [2, 0, 0, 3]
//If you dry run this without the edge case, the size of max sub-array will come as the output as 1 which refers to the number 3.
//But it should give the result as 3, with refer to the numbers [0, 0, 3], which is the longest sub-array.



//Below code is an optimal solution for input array containing only positive integers.
//Here we use a two-pointer approach.
//We add elemnts one by one to the 'sum' variable in each iteration.
//If the sum becomes greater than the target element, we keep shrinking the window by subtracting elements from the left and move the 'left' vaiable forward.
//When the 'sum' becomes lesser than or equal to the target(k), we stop shrinking.
//Now, if the 'sum' is equal to the target and is greater than the max-size of the sub-array, we update the max-size.
//At last, we moce the right pointer forward and keep repeating until we cross the index-bounds.

//Time complexity: O(2n) = O(n)
//Space complexity: O(1)
class Solution1 {
    public int longestSubArrayWithSumK1(int[] nums, int k) {
        int sum = 0;
        int maxCount = 0;
        int right = 0;
        int left = 0;
        while(right<nums.length) {
            sum+=nums[right];
            while(sum>k && left<=right) {
                sum = sum - nums[left];
                left++;
            }
            if(sum==k) {
                int count = right-left+1;
                if(count>maxCount) {
                    maxCount = count;
                }
            }
            right++;
        }
        return maxCount;
    }
}
