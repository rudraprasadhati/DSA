package Arrays.FAQs_Medium.TwoSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
//Brute force solution
//Time complexity: O(n^2)
//Space complexity: O(1)
//    public int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        for(int i = 0; i<nums.length; i++) {
//            for(int j = i+1; j<nums.length; j++) {
//                if(nums[i]+nums[j]==target) {
//                    res[0] = i;
//                    res[1] = j;
//                    return res;
//                }
//            }
//        }
//        return res;
//    }

//Better solution
//Time complexity: O(n)
//We have taken an unordered map, which generally takes O(1) time complexity for searching, but in the worst case it can go upto O(n^2), making the overall time complexity of O(n^2).
//Space complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int remainingValue = target-nums[i];
            if(map.containsKey(remainingValue)) {
                res[0] = i;
                res[1] = map.get(remainingValue);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 7, 4, 9, 2, 10, 3, 1};
        int target = 15;
        Solution s = new Solution();
        int[] res = s.twoSum(arr, target);
        System.out.println("The numbers are: "+arr[res[0]]+" and "+arr[res[1]]);

    }
}

//Note: In this question, it has asked us to return the indexes of the two elements which add up to the target.
//So if this is our question, the better solution above is our optimal solution.
//But if the question is of another variety where we just have to give an answer YES or NO, about, whether the elements are present or not in the array, then in that scenario, there is another optimal solution which uses a two-pointer approach, and is slightly better than the above better solution.
