/*
Majority Element II
Given an integer array of size n, find all elements that appear more than ? n/3 ? times.
Note: The algorithm should run in linear time and in O(1) space.
Example 1:
Input: [3,2,3]
Output: [3]
Example 2:
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //max number possible is 2 in the list - By Moore's Voting Algorithm
        int a = 0,aCount = 0;
        int b = 0,bCount = 0;
        int maxOccurence = nums.length / 3;
        List <Integer> majorityElementList = new ArrayList<>();
        for(int n : nums){
            if(a == n)
                aCount++;
            else if(b == n)
                bCount++;
            else if(aCount == 0){
                a = n;
                aCount = 1;
            }
            else if(bCount == 0){
                b = n;
                bCount++;
            }
            else{
                aCount--;
                bCount--;
            }
        }
        aCount = 0;
        bCount = 0;
        for (int n:nums){
            if(a == n)
                aCount++;
            else if(b == n)
                bCount++;
        }
        if(aCount > maxOccurence)
            majorityElementList.add(a);
        if(bCount > maxOccurence)
            majorityElementList.add(b);
        return majorityElementList;             
    }
}
