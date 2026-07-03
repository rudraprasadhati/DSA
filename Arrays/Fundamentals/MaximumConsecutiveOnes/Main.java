package Arrays.Fundamentals.MaximumConsecutiveOnes;

class Solution {
    public int maximumConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxOnes = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]==1) {
                counter++;
            }
            if(counter>maxOnes) {
                maxOnes = counter;
            }
            if(nums[i]==0) {
                counter = 0;
            }
        }
        return maxOnes;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        Solution s = new Solution();
        int res = s.maximumConsecutiveOnes(arr);
        System.out.println("The maximum number of consecutive ones in this array: "+res);

    }
}

//Time complexity: O(n)
