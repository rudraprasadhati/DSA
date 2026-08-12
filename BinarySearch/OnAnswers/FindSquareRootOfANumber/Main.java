package BinarySearch.OnAnswers.FindSquareRootOfANumber;

class Solution {
//Brute force solution
//Time complexity: O(n^0.5)
//Space complexity: O(1)
//    public int findSquareRootOfANumber(int num) {
//        long res = 0;
//        for(long i = 0; i<num; i++) {
//            if(i*i<=num) {
//                res = i;
//            }
//            else {
//                break;
//            }
//        }
//        return (int)res;
//    }

//Optimal solution
    public int findSquareRootOfANumber(int num) {
        long res = 0;
        long low = 1;
        long high = num;
        while(low<=high) {
            long mid = low+((high-low)/2);
            if(mid*mid==num) {
                return (int)mid;
            }
            else if(mid*mid<num) {
                res = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return (int)res;
    }
}
public class Main {
    public static void main(String[] args) {

        int number = 28;
        Solution s = new Solution();
        int res = s.findSquareRootOfANumber(number);
        System.out.println("The square root of the number is: "+res);

    }
}

//Time complexity: O(log n)
//Space complexity: O(1)

//Note regarding questions: If anytime you have to find something like a maximum/minimum number within a range, you can always go for binary search.
