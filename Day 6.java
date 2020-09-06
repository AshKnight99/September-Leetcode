/*
Image Overlap
Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
(Note also that a translation does not include any kind of rotation.)
What is the largest possible overlap?
Example 1:
Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 
1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1
*/
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        List<int[]> la = new ArrayList<>(), lb = new ArrayList<>(); 
        for (int r = 0; r<rows; r++)
            for (int c = 0; c<cols; c++){
                if (A[r][c] == 1) la.add(new int[]{r,c}); 
                if (B[r][c] == 1) lb.add(new int[]{r,c});
            }
        Map<String, Integer> map = new HashMap<>(); 
        for (int[] pa : la)
            for (int[] pb : lb) {
                String s = (pa[0] - pb[0]) + " " + (pa[1] - pb[1]); 
                map.put(s, map.getOrDefault(s, 0) + 1); 
            }
        int max = 0;
        for (int count : map.values())
            max = Math.max(max, count);
        return max;            
    }
}