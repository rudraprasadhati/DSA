package Arrays.FAQs_Medium.NextPermutation;

class Solution {
//Brute force solution: the brute force solution is very expensive in terms of time complexity, so we have to just discuss it and tell the idea and intuition behind it.
//For the brute-force solution, we will just generate all the possible permutations by recursion, and after generating all of the permutations, we can simply run a loop through all the permutation which will give the next permutation of the current permutation.
//Time complexity: n * n!
//Space complexity: n * n!
//We will analyseing the time and space complexity in more detail in the recursion part, where we will b implementing this code.

//Optimal solution
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if(pivot==-1) {
            int j = nums.length-1;
            for(int i = 0; i<nums.length/2; i++) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
            return;
        }
        for(int i = nums.length-1; i>pivot; i--) {
            if(nums[i]>nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }
        int startIndex = pivot+1;
        int endIndex = nums.length-1;
        while(startIndex<endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 3, 2};
        int[] temp = arr.clone();
        Solution s = new Solution();
        s.nextPermutation(arr);
        System.out.println("The next permutation of ");
        for(int i: temp) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("is: ");
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}

//Time complexity: O(n + n + n/2) = O(n)
//Space complexity: O(1)


//Intuition: There are three steps for this question to solve. And there are two cases which we have to handle.

//First case is that, we got permutation which is in decreasing order, so we will just simply reverse it, as it would give us the next permutation, i.e. the increasing order.

//Second case (general case): here in the second case, we start iterating through the array backwards, and there would always be an element present which would be smaller than it's next element.
//For example: [1, 2, 5, 4, 3]
//Here if we iterate backwards, and check the condition for: 'if(arr[i]<arr[i+1])', we will hit this condition, when our 'i' pointer will land on the number '2', cause its next number is '5', which is greater than '2'.
//Now we will assign this number's position(in this case: '2') to a variable 'pivot'.
//Now we again iterate from the end of the array till the pivot's next position, to find a number, which is just greater than our pivot value.
//We then swap the number which is just greater than the pivot's value, with our pivot's value, i.e. '2' will be swapped with '3'.
//Our array becomes: [1, 3, 5, 4, 2]
//At last we just simply reverse the values starting from the pivot's next position, till the end of the array, i.e. [5, 4, 2] becomes [2, 4, 5].
//Final answer: [1, 3, 2, 4, 5]
