/*
Unique Paths III
On a 2-dimensional grid, there are 4 types of squares:
1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
Example 1:
Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:
Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:
Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 Note:
1 <= grid.length * grid[0].length <= 20
*/
class Solution {
    int row ,col;
    public int uniquePathsIII(int[][] grid) {
        row = grid.length;
       col = grid[0].length;
        if(row == 0 || col == 0)
            return 0;
        int x = 0, y = 0, zeroes = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0)
                    zeroes++;
                else if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }                    
            }
        }
        return uniqueWalkingPath(x,y,zeroes,grid);
        
    }
    private int uniqueWalkingPath(int x,int y,int zeroes,int grid[][]){
        if(x < 0 || x >= row || y < 0 || y >= col)
            return 0;
        if(grid[x][y] == -1)
            return 0;
        if(grid[x][y] == 2)
            return zeroes == -1? 1 : 0;
        grid[x][y] = -1;
        zeroes--;
        int total = (  uniqueWalkingPath(x + 1,y,zeroes,grid)
                     + uniqueWalkingPath(x - 1,y,zeroes,grid)
                     + uniqueWalkingPath(x, y + 1,zeroes,grid) 
                     + uniqueWalkingPath(x, y - 1,zeroes,grid));
        grid[x][y] = 0;
        zeroes++;
        return total;
    }
}