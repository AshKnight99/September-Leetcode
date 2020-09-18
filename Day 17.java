/*
Robot Bounded In Circle
On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.
Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 Example 1:
Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:
Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.
Example 3:
Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
Note:
1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}
*/
class Solution {
    
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        //0 - North , 1 - West , 2 - South, 3 - East for direction  (refered in anticlockwise or left direction turn)
        int direction = 0;
        for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                if(direction == 0) // North
                    y++;
               else if(direction == 1) //West
                   x--;
                else if(direction == 2) // South
                    y--;
                else   //East
                    x++;
            }
            else if(ch == 'L'){
                direction = (direction + 1) % 4;
            }
            else {
                direction = direction == 0 ? 3 : (direction - 1);
            }
        }
        if((x == 0 && y == 0 ) || direction != 0)
            return true;
        
        return false;           
    }
}