package Arrays.FAQs_Medium.PrintTheMatrixInSpiralManner;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> printTheMatrixInSpiralManner(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length-1;
        int column = matrix[0].length-1;
        int left = 0;
        int right = column;
        int top = 0;
        int bottom = row;
        while(left<=right && top<=bottom) {
            for(int i = left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {
                for(int i = right; i>=left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for(int i = bottom; i>=top; i--) {
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
        List<Integer> res = s.printTheMatrixInSpiralManner(matrix);
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
//To help us better visualize the shrinking of the matrix which will help to get us know about the edge cases, keep the following intuition in mind which I had extracted from ChatGPT:

//  First for-loop
//  1. Traverse top row
//  2. top++
//
//  Second for-loop
//  3. Traverse right column
//  4. right--
//
//  Third for-loop
//  5. Traverse bottom row   <-- Is there still a bottom row?
//  6. bottom--
//
//  Fourth for-loop
//  7. Traverse left column  <-- Is there still a left column?
//  8. left++
