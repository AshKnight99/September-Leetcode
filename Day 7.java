/*
 Word Pattern
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String arr1[] = str.split(" ");
        char ch[] = pattern.toCharArray();
        if(ch.length != arr1.length)
            return false;
        //for(int i = 0;i < ch.length;i++)
          //  System.out.print("\n"+arr1[i]);
        HashMap<Character,String> map1 = new HashMap<>();
         HashMap<String,Character> map2 = new HashMap<>();
        for(int i = 0;i < ch.length;i++){
           // System.out.print("\nch :" + ch[i] );
            if(!map1.containsKey(ch[i]))
                map1.put(ch[i],arr1[i]);            
            else if(map1.containsKey(ch[i]) && !map1.get(ch[i]).equals(arr1[i]))
                return false;
             if(!map2.containsKey(arr1[i]))
                map2.put(arr1[i],ch[i]);
            
            else if(map2.containsKey(arr1[i]) && map2.get(arr1[i]) != ch[i])
                return false;            
            
        }
        return true;
    }
}