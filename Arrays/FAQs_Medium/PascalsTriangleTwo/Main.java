package Arrays.FAQs_Medium.PascalsTriangleTwo;

class Solution {
    public int[] pascalsTriangleTwo(int row) {
        int[] res = new int[row];
        int r = row-1;
        res[0] = 1;
        int product = 1;
        for(int i = 1; i<row; i++) {
            product = (product*r)/i;
            res[i] = product;
            r--;
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {

        int row = 6;
        Solution s = new Solution();
        int[] res = s.pascalsTriangleTwo(row);
        for(int i: res) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(r) = O(row-1) = O(row)
//Space complexity: O(row)

//Critical zone: make sure you understand how to implement the code, by a certain reoccurrence relation.
//For example:
//If we choose the row 6 as input with the first row taking as 1.
//Then, our row will contain 6 number of elements, and the first element will always be 1.
//After that, the next 5 elements would be: 5/1 -> (5/1)*(4/2) -> (5/1)*(4/2)*(3/3) -> (5/1)*(4/2)*(3/3)*(2/4) -> (5/1)*(4/2)*(3/3)*(2/4)*(1/5)
//So this is the reoccurrence relation we have to keep in mind.
//Also note that, there is a question which demands the same output, but the input would be a 0-base indexed Pascal's triangle, so make the necessary changes accordingly.
//Another small optimization which you can make is to keep the 'product' variable's data-type as 'long', to avoid integer overflow.
