package Arrays.FAQs_Medium.RotateMatrixBy90Degrees;

class Solution {
//Brute force solution
//Time complexity: O(n^2) + O(n^2) = O(n^2)
//Space complexity: O(n^2)
//How to tackle the problem: just write the indexes of each element row wise and compare it to the indexes of the same elements in the rotated matrix.
//You may find a pattern of the indexes they are mapped into, and then you can write the code easily to implement it.
//    public void rotateMatrixBy90Degrees(int[][] matrix) {
//        int[][] temp = new int[matrix.length][matrix[0].length];
//        for(int i = 0; i<matrix.length; i++) {
//            for(int j = 0; j<matrix[i].length; j++) {
//                temp[j][matrix.length-1-i] = matrix[i][j];
//            }
//        }
//        for(int i = 0; i<matrix.length; i++) {
//            for(int j = 0; j<matrix[i].length; j++) {
//                matrix[i][j] = temp[i][j];
//            }
//        }
//    }

//Optimal solution
    public void rotateMatrixBy90Degrees(int[][] matrix) {
        //First we convert the matrix into its transpose.
        for(int i = 0; i<matrix.length; i++) {
            for(int j = i+1; j<matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Then we reverse each row to get our rotated matrix.
        for(int i = 0; i<matrix.length; i++) {
            reverse(matrix, i, 0, matrix[i].length-1);
        }
    }
    private void reverse(int[][] matrix, int outerIndex, int start, int end) {
        for(int i = 0; i<matrix[i].length/2; i++) {
            int temp = matrix[outerIndex][start];
            matrix[outerIndex][start] = matrix[outerIndex][end];
            matrix[outerIndex][end] = temp;
            start++;
            end--;
        }
    }
}
public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution s = new Solution();
        s.rotateMatrixBy90Degrees(matrix);
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}

//Time complexity: O(n * n/2) + O(n) + O(n/2) = O(n^2)
//Space complexity: O(1)
