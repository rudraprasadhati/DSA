package BinarySearch.OnAnswers.FindNthRootOfTheNumber;

class Solution {
//Brute force solution (Gives TLE)
//Time complexity: O(m logn) ('m' is the number itself of whom we would have to find the root, and 'logn' is the complexity of 'pow()' function)
//Space complexity: O(1)
//    public int findNthRootOfTheNumber(int n, int m) {
//        int res = -1;
//        for(int i = 1; i<=m; i++) {
//            double num = Math.pow(i, n);
//            if(num==m) {
//                return i;
//            }
//            else if(num>m) {
//                break;
//            }
//        }
//        return res;
//    }

//Optimal solution
    public int findNthRootOfTheNumber(int n, int m) {
        int res = -1;
        int low = 1;
        int high = m;
        while(low<=high) {
            int mid = low+((high-low)/2);
            double num = pow(mid, n, m);
            if(num==1) {
                return mid;
            }
            else if(num==2) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return res;
    }
    private int pow(int mid, int n, int m) {
        long product = 1;
        for(int i = 1; i<=n; i++) {
            product*=mid;
            if(product>m) {
                return 2;
            }
        }
        if(product==m) {
            return 1;
        }
        return 0;
    }
}
public class Main {
    public static void main(String[] args) {

        int m = 81;
        int n = 3;
        Solution s = new Solution();
        int res = s.findNthRootOfTheNumber(n, m);
        if(res==-1) {
            System.out.println("The root doesn't exist.");
        }
        else {
            System.out.println("The "+n+" root of "+m+" is: "+res);
        }

    }
}

//Time complexity: O(logm logn) ('m' is the number itself of whom we would have to find the root, and 'logn' is the complexity of 'pow()' function)
//Space complexity: O(1)

//Note: In the optimal solution we are using our custom 'pow' function cause, if at a certain point the number(power of current iteration) goes beyond the variable 'm'(the number itself), we do not have to do any further checks, and we can break the loop at that point.
