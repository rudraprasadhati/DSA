package Arrays.Fundamentals.LinearSearch;

class Solution {
    public int linearSearch(int nums[], int target) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]==target) {
                return i;
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 2, 1, 3};
        int target = 3;
        Solution s = new Solution();
        int res = s.linearSearch(arr, target);
        if(res==-1) {
            System.out.println("The element is not present in the array.");
        }
        else {
            System.out.println("The element is present at index number: "+res);
        }

    }
}

//Time complexity: O(n)
