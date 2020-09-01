"""
Largest Time for Given Digits

Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
"""
class Solution:
    def largestTimeFromDigits(self, nums: List[int]) -> str:
        res=[]       
        
        def per(depth):
            if depth==len(nums)-1:
                res.append(nums[:])
            for i in range(depth,len(nums)):
                nums[i],nums[depth]=nums[depth],nums[i]
                per(depth+1)
                nums[i],nums[depth]=nums[depth],nums[i]
        per(0)        
        re=""
        for i in res:
            if i[0]*10 +i[1]<24 and i[2]*10+i[3]<60:
                re=max(re,str(i[0])+str(i[1])+':'+str(i[2])+str(i[3]))
        return re