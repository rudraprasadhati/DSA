package Arrays.Fundamentals.SecondLargestElement;

import java.util.*;

class Solution {
//My approach
//In this implementation, the code is a bit tricky, and is hard to read compared to the solution below which is not commented.
//Here the sorting functions takes O(n logn) time, and the while loop takes O(n) time, making the time complexity as: O(n logn)+O(n)
//As we ignore the insignificant values, the overall time complexity becomes: O(n logn)
//    public int secondLargestElement(int[] nums) {
//        if(nums.length<=1) {
//            return -1;
//        }
//        Arrays.sort(nums);
//        int i = nums.length-2;
//        while(i>0 && nums[i]==nums[nums.length-1]) {
//            i--;
//        }
//        if(nums[i]==nums[nums.length-1]) {
//            return -1;
//        }
//        return nums[i];
//    }

//My approach
//This is not optimal because it uses a tree-set, which requires a space complexity of O(n).
//The tree-set insertion also takes O(logn) time, and combined with the for loop, the over time complexity becomes O(n logn).
//    public int secondLargestElement(int[] nums) {
//        Set<Integer> s = new TreeSet<>();
//        for(int i = 0; i<nums.length; i++) {
//            s.add(nums[i]);
//        }
//        if(s.size()==1) {
//            return -1;
//        }
//        List<Integer> list = new ArrayList<>(s);
//        return list.get(list.size()-2);
//    }

//Brute force solution
//The sorting takes O(n logn), and the for-loop takes O(n) time, making the time complexity: O(n)+O(n logn)
//Overall time complexity: O(n logn) (as we ignore the insignificant values)
//    public int secondLargestElement(int[] nums) {
//        if(nums.length<=1) {
//            return -1;
//        }
//        Arrays.sort(nums);
//        int largest = nums[nums.length-1];
//        for(int i = nums.length-2; i>=0; i--) {
//            if(nums[i]!=largest) {
//                int secondLargest = nums[i];
//                return secondLargest;
//            }
//        }
//        return -1;
//    }

//Better solution
//Time complexity: O(n+n) = O(2n) = O(n)
//    public int secondLargestElement(int[] nums) {
//        if(nums.length<2) {
//            return -1;
//        }
//        int largestElement = Integer.MIN_VALUE;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]>largestElement) {
//                largestElement = nums[i];
//            }
//        }
//        int secondLargest = Integer.MIN_VALUE;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]>secondLargest && nums[i]!=largestElement) {
//                secondLargest = nums[i];
//            }
//        }
//        return secondLargest==Integer.MIN_VALUE ? -1 : secondLargest;
//    }

//Optimal Solution
    public int secondLargestElement(int[] nums) {
        if(nums.length<2) {
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]>largest) {
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i]<largest && nums[i]>secondLargest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest==Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 3, 1};
        Solution s = new Solution();
        int res = s.secondLargestElement(arr);
        if(res==-1) {
            System.out.println("There is a no second largest element in the array.");
        }
        else {
            System.out.println("The second largest element is: "+res);
        }

    }
}

//Time complexity: O(n)

//Critical zone: Remember to add a check condition for numbers which are smaller than "largest" variable but greater than the "secondLargest" variable.
