package Arrays.LogicBuilding.MoveZerosToEnd;

class Solution {
//Brute force solution
//Time complexity: O(n+n) = O(2n) = O(n)
//Space complexity: O(n)
//    public void moveZerosToEnd(int[] nums) {
//        if(nums.length<2) {
//            return;
//        }
//        int[] tempArr = new int[nums.length];
//        int nonZeroElementCounter = 0;
//        for(int i = 0; i<nums.length; i++) {
//            if(nums[i]!=0) {
//                tempArr[nonZeroElementCounter] = nums[i];
//                nonZeroElementCounter++;
//            }
//        }
//        for(int i = 0; i<nonZeroElementCounter; i++) {
//            nums[i] = tempArr[i];
//        }
//        for(int i = nonZeroElementCounter; i<nums.length; i++) {
//            nums[i] = 0;
//        }
//    }

//Optimal solution
    public void moveZerosToEnd(int[] nums) {
        if(nums.length<2) {
            return;
        }
        int i = 0;
        for(int j = 0; j<nums.length; j++) {
            if(nums[j]!=0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {3, 0, 4, 0, -2, 0, 0, 9};
        Solution s = new Solution();
        s.moveZerosToEnd(arr);
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n)

//Critical zone:
//Have a look on the "i" and "j" pointers, in the optimal solution.
//Look how the pointer "i" stops right at zero without moving forward.
//Here, you didn't scan for the zero with the "i" pointer, rather than you scanned the array with the "j" pointer looking for a non-zero element, and also it increases with each iteration.
//The overall idea is, in this two-pointer approach, you didn't use both of the pointers to scan the elements.
//We just use one of the pointer to look for a non-zero element, and with proper conditions, the other pointer, simple ended up at an element which is zero.
