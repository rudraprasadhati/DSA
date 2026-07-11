package Arrays.FAQs_Medium.PascalsTriangleThree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static List<Integer> printRowOfPascalsTriangle(int row) {
        List<Integer> list = new ArrayList<>();
        int r = row-1;
        list.add(1);
        int product = 1;
        for(int i = 1; i<row; i++) {
            product = (product*r)/i;
            r--;
            list.add(product);
        }
        return list;
    }
    public List<List<Integer>> pascalsTriangleThree(int row) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i<=row; i++) {
            list.add(printRowOfPascalsTriangle(i));
        }
        return list;
    }
}
public class Main {
    public static void main(String[] args) {

        int row = 5;
        Solution s = new Solution();
        List<List<Integer>> list = s.pascalsTriangleThree(row);
        for(int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}

//Time complexity: O(row^2) = O(n^2)
//Space complexity: O(row^2) = O(n^2)

//Critical zone: make sure to make the variable 'r' -> int r = row-1;
//This is same to the reoccurrence relation we have discussed in 'PascalsTriangleTwo', it's just a reminder to be careful with indexes and positions.
