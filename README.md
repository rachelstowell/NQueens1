# NQueens1

I. The Input

    The user enters an integer, n. 

II. The Output

    This program uses a stack and backtracking to find all possible 
solutions to the n-queens problem. The output will be an integer representing 
the number of ways to place n queens on an n-by-n chessboard such that no two 
queens are able to attack eachother (diagonally, vertically, or horizontally). 
The output will also display all safe arrangements of n queens on an n-by-n 
chessboard, where "Q" represents a queen and "-" represents an empty square.

III. An example

Enter integer
4
- Q - - 
- - - Q 
Q - - - 
- - Q - 

- - Q - 
Q - - - 
- - - Q 
- Q - - 

There are 2 solutions to the 4-queens problem.

IV. The Algorithm 

    Initialize a stack to keep track of the decisions. Place
the first queen, pushing it's position onto the stack and setting column to 0.
Repeat this process:
a) If there are no conflicts with the queens....
        -Increase filled by 1. If filled is now n, the algorithm is done.
        Othwerwise, move to the next row and place a queen in the first column.
b) Else if there is a conflict and there is room to shift the current queen rightward....
        -Move the current queen rightward, adjusting the record on top of the stack
        to indicate the new position. 
c) Else if there is a conflict and there is no room to shift the current queen rightward....
        -Backtrack. Keep popping the stack and reducing by 1 until you reach a row where the 
        queen can be shifted rightward. Shift this queen right. 
