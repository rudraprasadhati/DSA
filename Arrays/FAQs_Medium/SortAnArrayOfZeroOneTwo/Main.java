package Arrays.FAQs_Medium.SortAnArrayOfZeroOneTwo;

import java.util.Arrays;

class Solution {
//Brute force solution
//Time complexity: O(n logn)
//    public void  sortZeroOneTwo(int[] nums) {
//        Arrays.sort(nums);
//    }

//Better solution
//Time complexity: O(n+n) = O(n)
//    public void  sortZeroOneTwo(int[] nums) {
//        int countZero = 0;
//        int countOne = 0;
//        int countTwo = 0;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]==0) {
//                countZero++;
//            }
//            else if(nums[i]==1) {
//                countOne++;
//            }
//            else {
//                countTwo++;
//            }
//        }
//        for(int i = 0; i<countZero; i++) {
//            nums[i] = 0;
//        }
//        for(int i = countZero; i<(countZero+countOne); i++) {
//            nums[i] = 1;
//        }
//        for(int i = (countZero+countOne); i<(countZero+countOne+countTwo); i++) {
//            nums[i] = 2;
//        }
//    }

//Optimal solution
    public void  sortZeroOneTwo(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high) {
            if(nums[mid]==0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1) {
                mid++;
            }
            else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 1, 2, 0, 0};
        Solution s = new Solution();
        s.sortZeroOneTwo(arr);
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n)
//Space complexity: O(1)
//The optimal solution uses the Dutch national flag algorithm. The core idea of this algorithm depends on three cases. To understand and to know the intuition behind it, watch Striver's video.
