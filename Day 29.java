/*
Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
Note:The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new int[s.length()];
        return helper(s, wordDict, 0);
    }
    
    private int[] cache;
    private boolean helper(String s, List<String> wordDict, int begin) {
        if (begin == s.length()) return true;
        if (cache[begin] != 0) return cache[begin] == 1;

        boolean result = false;
        for (String word : wordDict) {
            if (s.startsWith(word, begin)) {
                result = result || helper(s, wordDict, begin + word.length());
                if (result) break;
            }
        }
        cache[begin] = result ? 1 : -1;
        return result;
    }
}
/*
//Like a Trie
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return processWordBreak(s, wordDict, new HashMap<String,Boolean>());        
    }
private boolean processWordBreak(String s, List<String> wordDict, HashMap<String,Boolean> wordStore){
        if(wordDict.contains(s))
            return true;
        else if (wordStore.containsKey(s))
            return wordStore.get(s);
        for(int i = 0;i < s.length();i++){
            if(wordDict.contains(s.substring(0, i)) &&                          processWordBreak(s.substring(i), wordDict, wordStore) ){
                wordStore.put(s,true);
                return true;
            }
        }
        wordStore.put(s,false);
        return false;
    }
}
*/