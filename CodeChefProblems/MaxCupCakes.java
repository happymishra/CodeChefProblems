import java.io.*;
import java.util.*;

class MaxCupCakes {
	public static void main (String args[]) {
		Scanner stdin = new Scanner(System.in);
		int noOfCases = stdin.nextInt();
		int cupCakesPerPkg = 0;

		for(int i = 0; i < noOfCases; i++) {
			int noOfCupCakes = stdin.nextInt();

			if(noOfCupCakes == 2 || noOfCupCakes  == 1) {
				cupCakesPerPkg = noOfCupCakes;
			}else if (noOfCupCakes % 2 == 0){
				cupCakesPerPkg = (noOfCupCakes / 2) + 1;
			}else {
				cupCakesPerPkg = (noOfCupCakes + 1)/2;
			}

			System.out.println(cupCakesPerPkg);
		}
	}
}