/*
Code Eval: https://www.codeeval.com/public_sc/56/

A robot is located in the upper-left corner of a 4×4 grid. The robot can move either up, down, left, or right, 
but cannot go to the same location twice. The robot is trying to reach the lower-right corner of the grid. 
Your task is to find out the number of unique ways to reach the destination.

INPUT SAMPLE:
    There is no input for this program.

OUTPUT SAMPLE:
    Print out the number of unique ways for the robot to reach its destination. The number should be printed out as an integer ≥0.

 */
public class RobotMovements 
{
    private static int allPossiblePaths = 0;
    private static final int GRIDSIZE = 4;
    private static boolean grid[][] = new boolean[GRIDSIZE][GRIDSIZE];

    public static void main(String[] args) 
    {
        grid[0][0] = true;
        start(0, 1);
        System.out.println(allPossiblePaths);
    }

    //Move to each neighbour of cell
    private static void start(int row, int column) 
    {
        grid[row][column] = true;
        moveUp(row, column);
        moveDown(row, column);
        moveLeft(row, column);
        moveRight(row, column);
    }

    //Move the robot in upwards direction and then move to all the neighbour of the cell
    private static void moveUp(int row, int column) 
    {
        //Robot is not in the uppermost row and the upper cell is not visited yet
        if (column > 0 && (!grid[row][column - 1])) 
        {
            moveRobotRecursively(row, column - 1);
        }
    }

    //Move the robot in left direction and then move to all the neighbour of the cell
    private static void moveLeft(int row, int column) 
    {
        //Robot is not in the leftmost row and the left cell is not visited yet
        if (row > 0 && (!grid[row - 1][column])) 
        {
            moveRobotRecursively(row - 1, column);
        }
    }

    //Move the robot in downwards direction and then move to all the neighbour of the cell
    private static void moveDown(int row, int column) 
    {
        //Robot has reached to the destination i.e. the right lowermost cell
        if (row == (GRIDSIZE - 1) && column == (GRIDSIZE - 1)) 
        {
            allPossiblePaths++;
            grid[row][column] = true;
        } //Robot is not in the lowermost row and the below cell is not visited yet
        else if (column < (GRIDSIZE - 1) && (!grid[row][column + 1])) 
        {
            moveRobotRecursively(row, column + 1);
        }
    }

    //Move the robot in right direction and then move to all the neighbour of the cell
    private static void moveRight(int row, int column) 
    {
        //Robot has reached to the destination i.e. the right lowermost cell
        if (row == (GRIDSIZE - 1) && column == (GRIDSIZE - 1)) 
        {
            allPossiblePaths++;
            grid[row][column] = true;
        } //Robot is not in the rightmost row and the right cell is not visited yet
        else if (row < (GRIDSIZE - 1) && (!grid[row + 1][column])) 
        {
            moveRobotRecursively(row + 1, column);
        }
    }
    
    //Call start function for each cell after robot moves to that cell 
    private static void moveRobotRecursively(int row, int column) {
        grid[row][column] = true;
        start(row, column);
        //Set the cell to false for the next path
        grid[row][column] = false;
    }
}