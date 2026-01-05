package arrays.FAQsMedium.printTheMatrixInSpiralManner;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralMatrix(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;
        int top = 0;
        int left = 0;
        int bottom = m-1;
        int right = n-1;
        while(top<=bottom && left<=right) {
            for(int i = left; i<=right; i++) {
                result.add(arr[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(arr[i][right]);
            }
            right--;
            //here below we are checking for the valid top-bottom cause the top(at least) has been changed above but not for the valid left-right cause its being checked in the loop
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(arr[bottom][i]);
                }
                bottom--;
            }
            //here below we are checking for the valid left-right cause the right(at least) has been changed above but not for the valid top-bottom cause its being checked in the loop
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(arr[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        Solution s = new Solution();
        List<Integer> result = s.spiralMatrix(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

//Time Complexity: O(m*n) //as we are visiting every single element once
//Space Complexity: O(m*n)
//m: rows
//n: columns