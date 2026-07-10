package Arrays.FAQs_Medium.PascalsTriangleOne;

class Solution {
    public int pascalsTriangleOne(int row, int column) {
        int n = row-1;
        int r = column-1;
        int iterations = Math.min(r, n-r);
        int result = 1;
        for(int i = 0; i<iterations; i++) {
            result = (result*n)/(i+1);
            n--;
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {

        int row = 5;
        int column = 5;
        Solution s = new Solution();
        int res = s.pascalsTriangleOne(row, column);
        System.out.println("The element of the Pascal's triangle is: "+res);

    }
}

//Time Complexity: O(min(r, n-r)), where n = row-1 and r = column-1
//Space Complexity: O(1)

//Notes:
//Here we will be using the formula of combination: nCr
//The formula for this question where we have to find the specific element of a certain row and column of the Pascal's triangle is:
//(n-1)C(r-1) = (n-1) choose (r-1) (the formula of combination)
//Here we can map the formula into row and columns by: (r-1)C(c-1) ((row-1) choose (column-1))

//Critical zone:
//The formula nCr is: n!/(r!)(n-r)!
//We already know that, 'r' is always smaller than or equal to 'n'
//So if we go further down this formula, we will see that the MAXIMUM term out of '(n-r)!' or 'r!' will cancel all the numbers from the 'n!', and 'n' will get left with the number of elements equal to the number of elements of minimum(r, n-r).
//So instead of leaving all the simplification to the computer, we can optimize the loop by making it running until minimum(r, n-r) times.
//Another small optimization which we can make so that the number don't overflow is that, with each iteration, divide the remaining elements of 'n' with the values of minimum(r, n-r) from last, so that the division starts from dividing the corresponding product by 1.
//It will make sure that the elements are perfectly divisible with ease, because if we start our division from 1, then possibly the next division would be followed by 2, and then 3 and then so on.
//It will be convinient because, 1 is divisible by all numbers, 2 is divisibile by every 2nd number, are so on.
