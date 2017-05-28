/*
https://www.codechef.com/SNCKQL17/problems/SNAKEEAT/

The Chef has acquired a vicious bunch of snakes, and these snakes are ever hungry and end up eating each other. 
In particular, each snake i has a length Li, whose initial value is given to you. A snake can eat any other 
snake which is not longer than itself. That is, snake i can eat snake j (i ≠ j), if Li ≥ Lj. And when a snake 
eats another snake, its length increases by 1. That is, Li increases by 1. A snake can eat multiple other snakes.

The Chef doesn't care about snakes eating each other. All he wants is to have as many snakes as possible, 
which are at least some particular lengths long. You are given Q values: K1, K2, .., KQ. Treat each of them 
independently and output the answer for each. That is, for each Ki, assume that you start out from the beginning 
with all the snakes alive and the lengths as the initial values given in the input, and find out the maximum 
number of snakes you can get whose length is at least Ki.

Input
	The first line contains an integer T, which is the number of testcases. The description of each testcase follows.

	The first line of each testcase contains two integers: N and Q, which denote the number of snakes initially, 
	and the number of queries, respectively.
	The second line contains N space separated integers: L1, L2, .., LN, the initial lengths of the snakes.
	The i-th of the next Q lines contains a single integer, Ki.
Output
	For each testcase, output Q lines, the i-th of which should have a single integer: The maximum number of 
	snakes the Chef can get which are of length at least Ki.
	Constraints
		1 ≤ T ≤ 5
		1 ≤ N, Q ≤ 10^5
		1 ≤ Li ≤ 10^9
		1 ≤ Ki ≤ 10^9
Example
	Input:
		2
		5 2
		21 9 5 8 10
		10
		15
		5 1
		1 2 3 4 5
		100
	Output:
		3
		1
		0
Explanation
	In the first testcase, first query, the second snake (length 9) can eat the fourth snake (length 8), 
	and hence make its length 10. Now, there are four snakes left, and their lengths are {21, 10, 5, 10}. So, we have three snakes with length ≥ 10: Two snakes of length 10 and one snake of length 21. This is the best you can do.

	In the second query, no matter what happens, you cannot get more than one snake of length ≥ 15.

	In the second testcase, no matter what happens, you cannot get any snake of length ≥ 100. Hence the answer is 0.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
 
class SnakeEat {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int noOfTestCases = Integer.parseInt(br.readLine());
		StringBuilder  output = new StringBuilder();
		StringTokenizer st;
 
		for(int i=0; i < noOfTestCases; i++) {
 
			st = new StringTokenizer(br.readLine()," "); 
			int noOfSnakes = Integer.parseInt(st.nextToken());
			int noOfQueries = Integer.parseInt(st.nextToken());
			
 
			int snakes [] = new int[noOfSnakes];
 
			st = new StringTokenizer(br.readLine()," "); 
			int c = 0;
			while(st.hasMoreTokens()) {
				snakes[c++] = Integer.parseInt(st.nextToken());
			}			
 
			Arrays.sort(snakes);
			int query, snakesForChef, processedSnakes;
 
			while(noOfQueries > 0) {
 
				query = Integer.parseInt(br.readLine());
				snakesForChef = 0;
				processedSnakes=0;
 
				for(int k=noOfSnakes - 1; k >= 0; k--) {
					if(snakes[k] < query) {
                        int eligibleSnakeLength = query - snakes[k];
 
                        if(k >= eligibleSnakeLength && processedSnakes <= k) {
                            processedSnakes += eligibleSnakeLength;
                        } else {
                            break;
                        }
                    }
                    snakesForChef++;
				}
				output.append(snakesForChef);
				output.append(System.getProperty("line.separator"));
				noOfQueries--;
			}
 
		}
		System.out.println(output.substring(0, output.lastIndexOf("\n")));
	}
 
} 