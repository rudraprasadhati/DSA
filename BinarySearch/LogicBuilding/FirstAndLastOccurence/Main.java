package BinarySearch.LogicBuilding.FirstAndLastOccurence;

class Solution {
//Brute force solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int[] firstAndLastOccurence(int[] nums, int target) {
//        int[] res = {-1, -1};
//        int count  = 0;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]==target && count==0) {
//                res[0] = i;
//                res[1] = i;
//                count++;
//            }
//            else if(nums[i]==target && count>0) {
//                res[1] = i;
//            }
//        }
//        return res;
//    }

//Better solution
//Time complexity: O(log n) + O(log n) = O(2log n) = O(log n)
//Space complexity: O(1)
//    public int[] firstAndLastOccurence(int[] nums, int target) {
//        int firstIndex = lowerBound(nums, target);
//        if(firstIndex==nums.length || nums[firstIndex]!=target) {
//            return new int[]{-1, -1};
//        }
//        int secondIndex = upperBound(nums, target);
//        return new int[]{firstIndex, secondIndex-1};
//    }
//    private int lowerBound(int[] nums, int target) {
//        int ans = nums.length;
//        int low = 0;
//        int high = nums.length-1;
//        while(low<=high) {
//            int mid = low+((high-low)/2);
//            if(nums[mid]>=target) {
//                ans = mid;
//                high = mid-1;
//            }
//            else {
//                low = mid+1;
//            }
//        }
//        return ans;
//    }
//    private int upperBound(int[] nums, int target) {
//        int ans = nums.length;
//        int low = 0;
//        int high = nums.length-1;
//        while(low<=high) {
//            int mid = low+((high-low)/2);
//            if(nums[mid]>target) {
//                ans = mid;
//                high = mid-1;
//            }
//            else {
//                low = mid+1;
//            }
//        }
//        return ans;
//    }

//Optimal solution
    public int[] firstAndLastOccurence(int[] nums, int target) {
        int firstIndex = firstOccurence(nums, target);
        if(firstIndex==-1) {
            return new int[]{-1, -1};
        }
        int secondIndex = secondOccurence(nums, target);
        return new int[]{firstIndex, secondIndex};
    }
    private int firstOccurence(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]==target) {
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
    private int secondOccurence(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low+((high-low)/2);
            if(nums[mid]==target) {
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Solution s = new Solution();
        int[] res = s.firstAndLastOccurence(arr, target);
        System.out.println("The target start from "+res[0]+" till "+res[1]);

    }
}

//Time complexity: O(log n) + O(log n) = O(2log n) = O(log n)
//Space complexity: O(1)

//Note:
//We first simple do a binary search to find the first occurence of the target with a slight modification in the binary-search algorithm that, if we find an element which is equakl to the target, then we trim the right half, as we are trying to find the first occurence which would possibly be on left.
//After we check for the first occurence, we will just add a condition to handle an edge case that if the target of not found, then we will not check for the second-occurence which would be a waste of time, and simply return [-1, -1].
//Similarly, when we will find the second occurence, then we again run the binary-search algorithm with a slight modification that, if we find an element that is equal to the target, then we simply omit the left half, and try to find the next occurence which could possibly be on the right side of the array.
