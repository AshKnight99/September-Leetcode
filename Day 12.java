/*
Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
class Solution {
    List <List<Integer>> list;
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();      
        List <Integer> l = new ArrayList<>();        
        combinations(n,k,l,1);
        return list;
    }
    private void combinations(int n,int k, List<Integer> l,int index){
        if(n == 0 && k == 0){
            list.add(new ArrayList<>(l));
            //System.out.print(list);           
            return;
        }
        if ((k == 0 && n!= 0) || (k!=0 && n==0))
            return;
       // System.out.print(l);
        for(int i = index;i <= 9;i++){
            l.add(i);
            combinations(n - i,k - 1 ,l,i + 1);
            l.remove(l.size() - 1);
        }        
    }
}