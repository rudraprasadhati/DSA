package arrays.FAQsMedium.rotateMatrixBy90Degrees;

class Solution {
    //1st we took out the transpose of the matrix and then we reversed it
    public int[][] rotateMatrix(int[][] arr) {
        //transpose of the matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                else {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        //copied code for reversing the matrix
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1-j];
                arr[i][arr.length-1-j] = temp;
            }
        }
        return arr;
    }
}
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution s = new Solution();
        int[][] result = s.rotateMatrix(arr);
        for(int i = 0; i<result.length; i++) {
            for(int j = 0; j<result.length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}

//Time Complexity: O((n)*(n/2)) = O(n**2) (we have not taken the time complexity of reverse function into consideration)
//Space Complexity: O(1)



//Brute Force method:

//class Solution {
//    public int[][] rotateMatrix(int[][] arr) {
//        int m = arr.length-1;
//        int[][] result = new int[arr.length][arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                result[j][m] = arr[i][j];
//            }
//            m--;
//        }
//        return result;
//    }
//}

//Complexities of brute force method:
//Time Complexity: O(n**2)
//Space Complexity: O(n**2)