/*
https://www.codechef.com/SNCKPA17/problems/ISSNAKE

One day I was visiting a temple in which snakes were worshiped. I happened to find a golden plate of dimension 2 * n in it. 
It had 2 rows of n cells each, and so the total number of cells is 2 * n. Each cell of the plate was either white or black, 
denoted by '.' and '#' respectively. Legend says that a snake was lying on this plate for many years and prayed. So, 
the cells that were covered by its body have turned black, the rest of the cells were white. Its entire body was supposedly 
on this plate. Also, you know that a snake likes to make itself comfortable, so none of its parts will be intersecting with 
its other parts.

Usually, I am skeptical of such legends. So, I want to check for myself whether the legend could potentially be true or not. 
For example, consider the golden plate given below:

    ##
    ##
    Now, the legend could be true. A snake can be on it, and one possible configuration is as follows. 
    The head of the snake is at (1, 1), then the next portion at (1, 2), then at (2, 2) and then the 
    finally the tail at (2, 1). Notice that the parts of the snake can be adjacent only if the corresponding 
    cells have a common side.

    ##.#..
    .###..
    There can be a snake on the plate above.


    ##.##
    .#.#.
    The legend is surely false if the plate is as above. These are not marks of a single snake. 
    There could be more than one possible snakes here. But not a single snake.

    Given the description of the plate, figure out if the legend could be true, or if it is definitely false.

Input
    The first line of the input contains an integer T denoting the number of test cases. The description of T 
    test cases follows.

    The first line of each test case contains an integer n.

    The next two lines each contain n characters denoting the rows of the plate.

Output
    For each test case, output a single line containing "yes" or "no" (without quotes) corresponding to the answer of the problem.

Constraints
    1 ≤ T ≤ 500
    1 ≤ n ≤ 500
    There will be at least one cell containing the character '#'

Example

    Input
        6
        2
        ##
        ..
        2
        ##
        .#
        2
        #.
        .#
        7
        #.###..
        #######
        6
        ##.#..
        .###..
        5
        ##.##
        .#.#.

    Output
        yes
        yes
        no
        no
        yes
        no

*/

import java.io.IOException;
import java.io.InputStreamReader;

class IsItSnake {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int noOfCases = Integer.parseInt(br.readLine());
        String [] output = new String[noOfCases];

        for(int i = 0; i < noOfCases; i++) {
            int noOfCells = Integer.parseInt(br.readLine());
            String firstRow = br.readLine();
            String secondRow = br.readLine();

            String [] firstRowStr = firstRow.split("");
            String [] secondRowStr = secondRow.split("");

            boolean aIndex = true;
            boolean noSnake = false;
            int hashCount = 0;

            for( int j = 0; j < noOfCells; j++) {
                if(aIndex && firstRowStr[j].equals("#") && secondRowStr[j].equals("#")) {
                    aIndex = false;
                    noSnake = true;
                    hashCount++;
                } else if(aIndex && firstRowStr[j].equals("#") && !secondRowStr[j].equals("#")) {
                    aIndex = true;
                    noSnake= true;
                    hashCount++;
                }else if(!aIndex && secondRowStr[j].equals("#") && firstRowStr[j].equals("#")) {
                    aIndex= true;
                    noSnake= true;
                    hashCount++;
                } else if (!aIndex && secondRowStr[j].equals("#") && !firstRowStr[j].equals("#")) {
                    aIndex = false;
                    noSnake = true;
                    hashCount++;
                } else if(!firstRowStr[j].equals("#") && !secondRowStr[j].equals("#")){
                    noSnake = true;
                    aIndex = true;
                    if(hashCount > 0 && (firstRow.indexOf("#", j) > -1 || secondRow.indexOf("#", j) > -1)) {
                        noSnake = false;
                        break;
                    }
                } else if(hashCount == 0 && secondRowStr[j].equals("#")){
                    noSnake = true;
                    aIndex = false;
                } else {
                    noSnake = false;
                    break;
                }
            }

            if(!noSnake) {
                output[i] = "no";
            } else {
                output[i] = "yes";
            }



        }
        for(int i = 0; i < noOfCases; i++) {
            System.out.println(output[i]);
        }

    }
}
