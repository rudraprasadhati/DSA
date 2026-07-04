package Arrays.Fundamentals.LeftRotateArrayByOne;

class Solution {
    public int[] leftRotateArrayByOne(int[] nums) {
        if(nums.length<2) {
            return nums;
        }
        int firstElement = nums[0];
        for(int i = 1; i<nums.length; i++) {
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = firstElement;
        return nums;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 3, 1};
        Solution s = new Solution();
        int[] res = s.leftRotateArrayByOne(arr);
        for(int i: res) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n)
