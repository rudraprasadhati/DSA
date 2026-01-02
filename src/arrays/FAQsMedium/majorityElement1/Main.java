package arrays.FAQsMedium.majorityElement1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] arr) {
        int count1 = 0;
        int key = -1;
        for(int i = 0; i<arr.length; i++) {
            if(count1==0) {
                key = arr[i];
                count1 = 1;
            }
            else if(arr[i]==key) {
                count1++;
            }
            else {
                count1--;
            }
        }
        int count2 = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i]==key) {
                count2++;
            }
        }
        if(count2>arr.length/2) {
            return key;
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 3, 2, 2};
        Solution s = new Solution();
        int result = s.majorityElement(arr);
        System.out.println("Majority element is: "+result);
    }
}

//Time Complexity: O(n)
//The time complexity can also be written as: "O(n)+O(n)", if there would be a possibility that there is no majority element present in the array. For which we have to put an extra loop to check for the same, making the time complexity "O(n)+O(n)" and not "O(n)".
//Space Complexity: O(1)



//Better method:

//class Solution {
//    public int majorityElement(int[] arr) {
//        Map<Integer, Integer> m = new HashMap<>();
//        for(int i = 0; i < arr.length; i++) {
//            if(m.containsKey(arr[i])) {
//                int x = m.get(arr[i]);
//                m.put(arr[i], ++x);
//            }
//            else{
//                m.put(arr[i], 1);
//            }
//        }
//        for(Map.Entry<Integer, Integer> map: m.entrySet()) {
//            if(map.getValue()>arr.length/2) {
//                return map.getKey();
//            }
//        }
//        return -1;
//    }
//}

//Complexities of better method:
//Time Complexity: O(n)(loop to traverse the array) + O(n)(to insert the unique elements into the unordered hashmap (worst case)) = O(n)
//Space Complexity: O(n) //to create a hashmap of size n (worst case)



//Brute force method:

//class Solution {
//    public int majorityElement(int[] arr) {
//        int n = arr.length;
//        for(int i = 0; i<n; i++) {
//            int count = 0;
//            for(int j = 0; j<n; j++) {
//                if(arr[i]==arr[j]) {
//                    count++;
//                }
//            }
//            if(count>n/2) {
//                return arr[i];
//            }
//        }
//        return -1;
//    }
//}

//Time Complexity of brute force method: O(n**2)