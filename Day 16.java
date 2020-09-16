/*
Maximum XOR of Two Numbers in an Array
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ? ai < 231.
Find the maximum result of ai XOR aj, where 0 ? i, j < n.
Could you do this in O(n) runtime?
Example:
Input: [3, 10, 5, 25, 2, 8]
Output: 28
Explanation: The maximum result is 5 ^ 25 = 28.
*/
class TrieNode{
    TrieNode map[];
    TrieNode(){
        map = new TrieNode[2];
    }
    
    public void addNum(int x){
        TrieNode t = this;
        for(int i = 31;i >= 0;i--){
            int val = (x >> i) & 1;
            if(t.map[val] == null){
                t.map[val] = new TrieNode();
            }
            t = t.map[val];
        }
    }
    
    public int getMaxXor(int x){
        TrieNode t = this;
        int xor = 0;
        for(int i = 31;i >= 0;i--){
            int val = (x >> i) & 1;
            if(t.map[val^1] != null){
                val = val ^ 1;
                xor += Math.pow(2,i);
            }
            t = t.map[val];
        }
        return xor;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            root.addNum(nums[i]);
            int here = root.getMaxXor(nums[i]);
            max = Math.max(here,max);
        }
        return max;
    }
}
