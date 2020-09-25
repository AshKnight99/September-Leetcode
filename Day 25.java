/*
Largest Number
Given a list of non negative integers, arrange them such that they form the largest number.
Example 1:
Input: [10,2]
Output: "210"
Example 2:
Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/
class Solution {
    public String largestNumber(int[] nums) {    
        int n = nums.length;
        String arr[] = new String[n];
        for(int i = 0;i < n;i++)
            arr[i] = String.valueOf(nums[i]);
        Arrays.sort(arr,(a,b) -> (b + a).compareTo(a + b));
        StringBuilder largestNum = new StringBuilder();
        for(String s : arr)
            largestNum.append(s);
        while(largestNum.length() > 1 && largestNum.charAt(0) == '0')
            largestNum.deleteCharAt(0);
        return largestNum.toString();
    }
}