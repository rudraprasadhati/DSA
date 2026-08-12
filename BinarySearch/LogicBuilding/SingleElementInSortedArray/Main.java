package BinarySearch.LogicBuilding.SingleElementInSortedArray;

class Solution {
//Brute force solution one
//Time complexity: O(n)
//Space complexity: O(1)
//    public int singleElementInSortedArray(int[] nums) {
//        if(nums.length==1) {
//            return nums[0];
//        }
//        int res = -1;
//        for(int i = 0; i<nums.length; i++) {
//            if(i==0) {
//                if(nums[i]==nums[i+1]) {
//                    continue;
//                }
//                else  {
//                    res = nums[i];
//                    break;
//                }
//            }
//            else if(i==nums.length-1) {
//                if(nums[i]==nums[i-1]) {
//                    continue;
//                }
//                else  {
//                    res = nums[i];
//                    break;
//                }
//            }
//            else {
//                if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1]) {
//                    res = nums[i];
//                }
//            }
//        }
//        return res;
//    }

//Brute force solution two
//Time complexity: O(n)
//Space complexity: O(1)
//    public int singleElementInSortedArray(int[] nums) {
//        if(nums.length==1) {
//            return nums[0];
//        }
//        int xor = 0;
//        for(int i = 0; i<nums.length; i++) {
//            xor^=nums[i];
//        }
//        return xor;
//    }

//Optimal solution
    public int singleElementInSortedArray(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        else {
            if (nums[0] != nums[1]) {
                return nums[0];
            }
            if (nums[nums.length - 1] != nums[nums.length - 2]) {
                return nums[nums.length - 1];
            }
        }
        int low = 1;
        int high = nums.length-2;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) {
                return nums[mid];
            }
            else if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2!=0 && nums[mid]==nums[mid-1])) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        Solution s = new Solution();
        int res = s.singleElementInSortedArray(arr);
        System.out.println("The number which occurs for a single time is: "+res);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//Note:
//Here the key is the indexes of the duplicate elements.
//The first duplicate occurs in an even position, and the second duplicate occurs in an odd position.
//But after crossing the single element, the first duplicate occurs in the odd position and the second duplicate occurs in the even position.
//So by keeping the above things in mind, we just have to eliminate either the left part of the array or the right part of the array.
