package Arrays.LogicBuilding.RemoveDuplicatesFromSortedArray;

import java.util.HashSet;
import java.util.Set;

class Solution {
//Brute force solution
//Time complexity: O(n logn+k) (k is the number of unique elements, and in worst case k could be equal to n) = O(n logn+n) = O(n logn)
//Space complexity: O(k) (k is the number of unique elements, and in worst case k could be equal to n) = O(n)
//    public int removeDuplicatesFromSortedArray(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i<nums.length; i++) {
//            set.add(nums[i]);
//        }
//        int j = 0;
//        for(int i: set) {
//            nums[j] = i;
//            j++;
//        }
//        return set.size();
//    }

    public int removeDuplicatesFromSortedArray(int[] nums) {
        int i = 0;
        for(int j = 0; j<nums.length; j++) {
            if(nums[i]!=nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1; //As here we are treating "i" as index, we have to return "i+1", so that it gives the actual length/number of unique elements.
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {-1, -1, 0, 1, 2, 2, 3, 4, 5};
        Solution s = new Solution();
        int res = s.removeDuplicatesFromSortedArray(arr);
        for(int i = 0; i<res; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n)
//Space complexity: O(1)

//Critical zone: Take a look on the part, where we manage the "i" pointer.
//To think and come up with a solution like this, you should always use a pen and paper to dry run and implement your processed algorithm.
