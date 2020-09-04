/*
Partition Labels
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts. 
Note:
S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        //By sliding window approach
        int n = S.length();
        if(n == 0)
            return new ArrayList<>();
        int alphabets[] = new int [26];
        List <Integer> list = new ArrayList<>();
        char ch[] = S.toCharArray();
        for(char c : ch)
            alphabets[c - 'a'] ++;
        HashSet <Character> set = new HashSet<>();
        int unique_count = 0;
        int l = 0,r = 0; //start and end of the sliding window
        while(r < n){
            char c = ch[r];
            if(!set.contains(c)){
                set.add(c);
                unique_count++;
            }
            alphabets[c - 'a'] --;
            r ++;
            if(alphabets[c - 'a'] == 0){
                unique_count --;
                set.remove(c);
            }
            if(unique_count == 0){
                list.add(r - l);
                l = r; 
            }
        }
        return list;        
    }
}