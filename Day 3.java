/*
Repeated Substring Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"
Output: False
Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
     int len = s.length();
        if(len == 0)
            return true;
        for(int i = len / 2;i >= 1; i--){            
            if(len % i != 0)
                continue;
            int sub_len = len / i;
            String sub_string = s.substring(0,i);
            StringBuilder s1 = new StringBuilder();
            
            for(int j = 1;j <= sub_len;j++)
                s1.append(sub_string);
           // System.out.print(s1);
            if(s1.toString().equals(s))
                return true;               
        }
        return false;        
    }
}