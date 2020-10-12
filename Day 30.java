/*
First Missing Positive
Given an unsorted integer array, find the smallest missing positive integer.
Example 1:
Input: [1,2,0]
Output: 3
Example 2:
Input: [3,4,-1,1]
Output: 2
Example 3:
Input: [7,8,9,11,12]
Output: 1
Follow up:
Your algorithm should run in O(n) time and uses constant extra space.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean hasOne = false;        
        for(int i = 0;i < len;i++){
            if(nums[i] == 1)
                hasOne = true;
            if(nums[i] <= 0 || nums[i] > len)
                nums[i] = 1;
        }
        
        if(!hasOne)
            return 1;
        for(int i = 0; i < len; i++){
            //System.out.print(nums[i]);
            int currIndex = Math.abs(nums[i]) - 1;
            if(nums[currIndex] > 0)
            nums[currIndex] = -nums[currIndex];
        }
        for(int i = 0; i < len; i++){
            if(nums[i] > 0)
                return i + 1;
        }
        return len + 1;
    }
}