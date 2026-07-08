package Arrays.FAQs_Medium;

class Solution {
//Brute force solution
//Time complexity: O(n^2)
//Space complexity: O(1)
//    public int majorityElement(int[] nums) {
//        int highestFrequnecy = 0;
//        for(int i = 0; i<nums.length; i++) {
//            int counter = 0;
//            for(int j = 0; j<nums.length; j++) {
//                if(nums[i]==nums[j]) {
//                    counter++;
//                }
//            }
//            if(counter>nums.length/2) {
//                highestFrequnecy = nums[i];
//            }
//        }
//        return highestFrequnecy;
//    }

//Better solution
//Time complexity: O(n)
//Space complexity: O(n)
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i<nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
//        }
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            if(entry.getValue()>nums.length/2) {
//                return entry.getKey();
//            }
//        }
//        return -1;
//    }

//Optimal solution
    public int majorityElement(int[] nums) {
        int i = 0;
        int currentElement = -1;
        int counter = 0;
        while(i<nums.length) {
            if(counter==0) {
                currentElement = nums[i];
                counter++;
                i++;
            }
            else {
                if(nums[i]!=currentElement) {
                    counter--;
                    i++;
                }
                else {
                    counter++;
                    i++;
                }
            }
        }
        int freequency = 0;
        for(int j = 0; j <nums.length; j++) {
            if(currentElement==nums[j]) {
                freequency++;
            }
        }
        if(freequency >nums.length/2) {
            return currentElement;
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {

        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        Solution s = new Solution();
        int res = s.majorityElement(arr);
        System.out.println("The majority element is: "+res);

    }
}

//Time complexity: O(n)+O(n) = O(n)
//Space complexity: O(1)

//Note:
//In the optimal solution, we will use the Boyer Moore's voting algorithm to find the majority element.

//Boyer Moore's majority voting algorithm:
//We move ahead across the array, and take the current element as a key, and as we move through the array, if we encounter the same current element, we will increase the counter by 1, if we don't encounter the same current element, then we will decrease the counter by 1.
//If our counter becomes 0(zero), in the middle of the iteration, then we get to know that, if our current element is present for n(counter) times in the array until this point, then there are also n(counter) number of elements which are not equal to our current element are also present in the array until the current iteration of the loop, so they cancel each other out and made the counter 0.
//Now we will continue this process until we exceed our array length, and if the counter is still greater than 0(zero), then we got to know that, there is an element in the array, which could have the highest frequency than others, because the counter is non-zero, which means, there are not enough elements which are not equal to the majority element, which would have cancelled each other out.
//In simple terms(by ChatGPT): Boyer–Moore is a pair-cancellation algorithm: it repeatedly cancels one occurrence of the current candidate with one different element, ensuring that if a majority element exists, it is the only value that can survive all cancellations.

//At last, according to our question, we then have a final check, i.e, if the majority element's frequency is more than that of the "array-length/2", then we simply return that element.
