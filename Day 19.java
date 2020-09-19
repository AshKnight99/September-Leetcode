/*
 Sequential Digits
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
Example 1:
Input: low = 100, high = 300
Output: [123,234]
Example 2:
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 Constraints:
10 <= low <= high <= 10^9
*/
class Solution {
    List <Integer> list;
    public List<Integer> sequentialDigits(int low, int high) {
        list = new ArrayList<>(); 
        combinations(low,high);
        Collections.sort(list);
        return list;        
    }
    private void combinations(int low,int high){
        for(int i = 1;i < 9;i++){
            int number = i;
            for(int j = i + 1;j < 10;j++){
                number = (number * 10) + j; 
                if(number >= low && number <= high)
                    list.add(number);
            }
        }
    }
}