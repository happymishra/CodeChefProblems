// https://www.hackerrank.com/challenges/staircase
/*
Consider a staircase of size :

   #
  ##
 ###
####

Observe that its base and height are both equal to , and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.

Write a program that prints a staircase of size .

Input Format

    A single integer, , denoting the size of the staircase.

Output Format

    Print a staircase of size  using # symbols and spaces.

Note: The last line must have  spaces in it.

Sample Input
    6 
Sample Output

         #
        ##
       ###
      ####
     #####
    ######
Explanation
    The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of .
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        StairCase(stdin.nextInt());
    }
    
      static void StairCase(int n) {

        for(int i= 1; i <=  n; i++)
        {
            for(int j = n; j > 0; j--)
             {
                 if(j > i)
                 {
                    System.out.print(" ");
                 }
                 else
                 {
                     System.out.print("#");
                 }

            }
            System.out.println();
        }
    }
    
}
