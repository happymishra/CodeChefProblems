import java.io.*;
import java.util.*;
import java.lang.Math;

class LeadGame {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(System.in);
		int noOfCases = stdin.nextInt();
		int winner = 0, lead = 0;

		for(int round = 0; round < noOfCases; round++){
			int p1 = stdin.nextInt();
			int p2 = stdin.nextInt();

			int currentRoundLead = Math.abs(p1 - p2);

			if(currentRoundLead > lead) {
				lead = currentRoundLead;

				if(p1 > p2){
					winner = 1;
				}else {
					winner = 2;
				}
			}
		}

		System.out.println(winner + " " + lead);
	}
}