package BinarySearch.LogicBuilding.FloorAndCeilInSortedArray;

class Solution {
//Brute-force solution
//Time complexity: O(n+n) = O(2n) = O(n)
//Space complexity: O(1)
//    public int[] floorAndCeilInSortedArray(int[] nums, int x) {
//        int[] res = {-1, -1};
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]==x) {
//                res[0] = x;
//                res[1] = x;
//                return res;
//            }
//            else if(nums[i]>x) {
//                res[1] = nums[i];
//                break;
//            }
//        }
//        for(int i = nums.length-1; i>=0; i--) {
//            if(nums[i]<x) {
//                res[0] = nums[i];
//                break;
//            }
//        }
//        return res;
//    }

//Optimal solution
    public int[] floorAndCeilInSortedArray(int[] nums, int x) {
        int[] res = {-1, -1};
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]==x) {
                res[0] = x;
                res[1] = x;
                return res;
            }
            else if(nums[mid]>x) {
                res[1] = nums[mid];
                high = mid-1;
            }
            else {
                res[0] = nums[mid];
                low = mid+1;
            }
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {325,382,556,684,742};
        int x = 5;
        Solution s = new Solution();
        int[] res = s.floorAndCeilInSortedArray(arr, x);
        System.out.println("The floor is: "+res[0]+" and the ceil is: "+res[1]);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)
