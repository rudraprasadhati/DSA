package arrays.fundamentals.linearSearch;

class Solution {
    public String linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] == x) {
                return "Element "+x+" is at index number: "+i;
            }
        }
        return "Element not found.";
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {34, 99, 100, 25, 73, 26, 8};
        int key = 26;
        Solution s = new Solution();
        String result = s.linearSearch(arr, key);
        System.out.println(result);
    }
}

/*
Time Complexity:
best: O(1) //if the element is at the first index.
worst: O(n) //if the element is not present in the array.
*/