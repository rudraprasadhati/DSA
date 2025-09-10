package arrays.fundamentals.maximumConsecutiveOnes;

class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        int count = 0;
        int max = 0;
        for(int i = 0; i<a.length; i++) {
            if(a[i] == 1) {
                count++;
                max = Math.max(count, max);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1};
        Solution s = new Solution();
        int result = s.findMaxConsecutiveOnes(arr);
        System.out.println("The maximum number of ones in the array: "+result);
    }
}

//Time Complexity = O(n)