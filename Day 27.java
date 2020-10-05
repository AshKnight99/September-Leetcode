/*
Evaluate Division
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 Constraints:
1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
*/
class Solution {
    Map <String , List<Edges>> valueMap;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        valueMap = new HashMap<>();
        double[] result=new double[queries.size()];
        int n = equations.size(); 
        for(int i = 0;i < n;i++){
            List <String> variables = equations.get(i);
            String A = variables.get(0);
            String B = variables.get(1);
            double weight = values[i];
            putValues(A,B,weight);
            putValues(B,A,1 / weight);
        }
        int i = 0;
        for(List <String> query : queries){
            String A = query.get(0);
            String B = query.get(1);
            double ans = -1;
            if(A.equals(B)){
                if(valueMap.get(A) != null)
                    ans = 1;
            }
            else if(valueMap.get(A) != null && valueMap.get(B) != null){
                ans = dfsPath(A, B, 1, new ArrayList<>());
            }    
            result[i++] = ans;
        }
        return result;
        
    }
    private void putValues(String A,String B,double weight){
        List <Edges> addEdge = valueMap.getOrDefault(A,new ArrayList<>());
        addEdge.add(new Edges(B,weight));
        valueMap.put(A,addEdge);        
    }
    private double dfsPath(String A,String B,double val ,List <String> visited){
        if(A.equals(B))
            return val;
        
        visited.add(A);
        for(Edges edge : valueMap.get(A)){
            if(!visited.contains(edge.getEdge())){
                double ans = dfsPath(edge.getEdge(),B,val * edge.getWeight(),visited);
                if(ans != -1)
                    return ans;
            }
        }
        return -1;
    }
