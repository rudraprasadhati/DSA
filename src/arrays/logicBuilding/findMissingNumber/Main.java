package arrays.logicBuilding.findMissingNumber;

class Solution {
    public int findMissingNumber(int[] a) {
        int xor1 = 0;
        int xor2 = 0;
        for(int i = 0; i<a.length; i++) {
            xor1 = xor1^i;
            xor2 = xor2^a[i];
        }
        xor1 = xor1^a.length;
        int xor = xor1^xor2;
        if(xor==0 && a[0]==0) {
            return -1;
        }
        return xor;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5, 6, 7, 8};
        System.out.println("Current elements: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Solution s = new Solution();
        int result = s.findMissingNumber(arr);
        if(result == -1) {
            System.out.println("There is no missing number");
        }
        else{
            System.out.println("The missing number is: "+result);
        }
    }
}

//The above method implemented is the optimal method 2.
//Time Complexity of optimal method 2: O(n)
//Space Complexity of optimal method 2: O(1)



//Optimal method 1:

//class Solution {
//    public int findMissingNumber(int[] a) {
//        int nums = (a.length*(a.length+1))/2;
//        int sum = 0;
//        for(int i: a) {
//            sum+=i;
//        }
//        int x = nums - sum;
//        //the below condition is for handling an edge case in which the 0 is already present in the array, but there is no missing number for which the above difference is also 0, fo which the statement will return -1 indicating there is no missing number
//        if(nums==sum && a[0]==0) {
//            return -1;
//        }
//        return x;
//    }
//}

//Time Complexity of optimal method 1: O(n)
//Space Complexity of optimal method 1: O(1)



//Better method:

//class Solution {
//    public int findMissingNumber(int[] a) {
//        int[] temp = new int[a.length+1];
//        for(int i: a) {
//            temp[i] = 1;
//        }
//        for(int i = 0; i<temp.length; i++) {
//            if(temp[i]==0) {
//                return i;
//            }
//        }
//        return -1;
//    }
//}

//Time Complexity for better method: O(n) + O(n) = O(2n)
//Space Complexity: The temp array taken to check for the missing element = O(n)



//Brute force method:

//class Solution {
//    public int findMissingNumber(int[] a) {
//        for(int i = 0; i<=a.length; i++) {
//            int flag = 0;
//            for(int j = 0; j<a.length; j++) {
//                if(a[j] == i) {
//                    flag = 1;
//                    break;
//                }
//            }
//            if(flag == 0) {
//                return i;
//            }
//        }
//        return -1;
//    }
//}

//Time Complexity of brute force method: O(n^2) (worst case)