package Arrays.LogicBuilding.FindMissingNumber;

class Solution {
//Brute force solution
//Time complexity: O(n^2)
//    public int findMissingNumber(int[] nums) {
//        for(int i = 0; i<=nums.length; i++) {
//            int flag = 0;
//            for(int j = 0; j<nums.length; j++) {
//                if(i==nums[j]) {
//                    flag = 1;
//                    break;
//                }
//            }
//            if(flag==0) {
//                return i;
//            }
//        }
//        return -1;
//    }

//Better solution
//Time complexity: O(n)+O(n) = O(2n) = O(n)
//Space complexity: O(n)
//    public int findMissingNumber(int[] nums) {
//        int[] tempArr = new int[nums.length+1];
//        for(int i = 0; i<tempArr.length-1; i++) {
//            if(nums[i]==i) {
//                tempArr[i] = 1;
//            }
//        }
//        for(int i = 0; i<tempArr.length; i++) {
//            if(tempArr[i]==0) {
//                return i;
//            }
//        }
//        return -1;
//    }

//First Optimal solution
//Time complexity: O(n)
//Space complexity: O(1)
//    public int findMissingNumber(int[] nums) {
//        int n = nums.length;
//        int sumOfNNumbers = (n*(n+1))/2;
//        int sumOfArray = 0;
//        for(int i = 0; i<nums.length; i++) {
//            sumOfArray+=nums[i];
//        }
//        return sumOfNNumbers-sumOfArray;
//    }

//Second optimal solution
//Time complexity: O(n)
//Space complexity: O(1)
//This optimal solution is slightly better than the first optimal solution, as the first optimal solution can cause an integer overflow, for which we have to use the "long" datatype, and "long" takes slightly more memory than "int".
    public int findMissingNumber(int[] nums) {
        int xor1= 0;
        int xor2 = 0;
        for(int i = 0; i<nums.length; i++) {
            xor1 = xor1^nums[i];
            xor2 = xor2^(i+1);
        }
        return xor1^xor2;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 3, 5, 4, 6};
        Solution s = new Solution();
        int res = s.findMissingNumber(arr);
        System.out.println("The missing number is: "+res);

    }
}
