package arrays.FAQsMedium.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8 , 7};
        int target = 14;
        Solution s = new Solution();
        int[] result = s.twoSum(arr, target);
        System.out.println("The two numbers are at the index: "+result[0]+","+result[1]);
    }
}

//Optimal method:

//This method can only be used to return the two numbers which adds up to the target. We cannot use this method to return the index of the numbers because when we sort the array we distort the elements with their corresponding indexes.

//class Solution {
//    public int[] twoSum(int[] arr, int target) {
//        int[] result = new int[2];
//        Arrays.sort(arr);
//        int i = 0;
//        int j = arr.length-1;
//        while(i<j) {
//            if(arr[i]+arr[j]>target) {
//                j--;
//            }
//            else if (arr[i]+arr[j]<target) {
//                i++;
//            }
//            else {
//                result[0] = arr[i];
//                result[1] = arr[j];
//                return result;
//            }
//        }
//        result[0] = -1;
//        result[1] = -1;
//        return result;
//    }
//}

//Complexities of optimal method:
//Time Complexity: O(n logn)+O(n)
//Space Complexity: O(1)



//Better method:

//class Solution {
//    public int[] twoSum(int[] arr, int target) {
//        int[] result = new int[2];
//        Map<Integer, Integer> h = new HashMap<>();
//        for(int i = 0; i<arr.length; i++) {
//            int x = target-arr[i];
//            if(h.containsKey(x)) {
//                result[0] = h.get(x);
//                result[1] = i;
//                return result;
//            }
//            h.put( arr[i], i);
//        }
//        result[0] = -1;
//        result[1] = -1;
//        return result;
//    }
//}

//Complexities of better method:
//Time Complexity: O(n*n) //as we have used an unordered map, so it will take O(n) time to search for an element in the worst case resulting in O(n**2) time complexity
//if we would use the ordered map (TreeMap) then it would take O(logn) to search for an element in the worst case, resulting in O(n logn) time complexity for which it would be better than the brute force method
//Space Complexity: O(n)



//Brute force method:

//class Solution {
//    public int[] twoSum(int[] arr, int target) {
//        int[] result = new int[2];
//        for(int i = 0; i<arr.length; i++) {
//            for(int j = i+1; j<arr.length; j++) {
//                if(arr[i]+arr[j]==target) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        result[0] = -1;
//        result[1] = -1;
//        return result;
//    }
//}

//Complexities of brute force method:
//Time Complexity: O(n**2)
//Space Complexity: O(1)