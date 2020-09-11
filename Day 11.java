/*Maximum Product Subarray
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
        //Calculate prefix and suffix and its maximum each time
       int n = nums.length, res = nums[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * nums[i];
            r =  (r == 0 ? 1 : r) * nums[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;        
    }
}