package Arrays.FAQs_Medium.PrintTheMatrixInSpiralManner;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> printMatrixInSpiralManner(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length-1;
        int column = matrix[0].length-1;
        int left = 0;
        int right = column;
        int top = 0;
        int bottom = row;
        while(left<=right && top<=bottom) {
            for(int  i = left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        Solution s = new Solution();
        List<Integer> res = s.printMatrixInSpiralManner(matrix);
        for(int i: res) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}


//Time complexity: O(M*N)
//Space complexity: O(M*N) (output space)
//Auxiliary space: O(1) (as no extra space is used here to solve the problem)

//Critical zone:
//Make sure to add the extra checks inside the while loop to tackle the edge cases.
