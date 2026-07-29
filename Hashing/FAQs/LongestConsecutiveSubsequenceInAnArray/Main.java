package Hashing.FAQs.LongestConsecutiveSubsequenceInAnArray;

import java.util.HashSet;
import java.util.Set;

class Solution {
//Brute force solution
//Time complexity: O(n^3)
//Space complexity: O(1)
//This code will give the TLE-error.
//    public int longestConsecutiveSubsequence(int[] nums) {
//        int longestSubsequence = 1;
//        for(int i = 0; i<nums.length; i++) {
//            int count = 1;
//            int currentElement = nums[i];
//            //This while-loop will take n^2 cause the while loop itself will take O(n) and the 'linearSearch' function will take O(n).
//            while(linearSearch(nums, currentElement+1)) {
//                count++;
//                currentElement++;
//            }
//            if(count>longestSubsequence) {
//                longestSubsequence = count;
//            }
//        }
//        return longestSubsequence;
//    }
//    private boolean linearSearch(int[] nums, int element) {
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]==element) {
//                return true;
//            }
//        }
//        return false;
//    }

//Better solution
//Time complexity: O(n logn)
//Space complexity: O(1)
//    public int longestConsecutiveSubsequence(int[] nums) {
//        Arrays.sort(nums);
//        int longestSubsequence = 1;
//        int count = 1;
//        for(int i = 0; i<nums.length-1; i++) {
//            if(nums[i]==nums[i+1]) {
//                continue;
//            }
//            else {
//                if(nums[i+1]==nums[i]+1) {
//                    count++;
//                }
//                else {
//                    count = 1;
//                }
//            }
//            if(count>longestSubsequence) {
//                longestSubsequence = count;
//            }
//        }
//        return longestSubsequence;
//    }

//Optimal solution
    public int longestConsecutiveSubsequence(int[] nums) {
        int longestSubsequence = 1;
        int count;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i: set) {
            if(set.contains(i-1)) {
                continue;
            }
            else {
                count = 1;
                int currentElement = i;
                while(set.contains(currentElement+1)) {
                    count++;
                    currentElement = currentElement+1;
                }
            }
            if(count>longestSubsequence) {
                longestSubsequence = count;
            }
        }
        return longestSubsequence;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Solution s = new Solution();
        int res = s.longestConsecutiveSubsequence(arr);
        System.out.println("The longest consecutive subsequence is: "+res);

    }
}

//Time complexity: O(n + 2n) = O(3n) = O(n)
//Also as we have taken an unordered set i.e. a hashset, so we are assuming all the operations would be taking O(1), it would be taking O(n) in very rare cases.
//Space complexity: O(n)

//Note:
//Here we are traversing through the array, and checking that if the current element has its previous consecutive element or not.
//If it has its previous consecutive element, we just move ahead.
//And if the current element doesn't have its previous consecutive element, we just run a loop from that element to check how many next-consecutive-elements(subsequence) are present in the array.

//Make sure to check for the constraints everytime before coding to avoid certain edge cases like empty array, etc.
