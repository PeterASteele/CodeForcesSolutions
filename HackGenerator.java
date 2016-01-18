import java.util.ArrayList;
import java.util.Scanner;

import java.math.BigInteger;
import java.util.Scanner;

public class HackGenerator {
	//Generating hack for LinkCutTree
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long start = 1;
		long end = 1000000000000000000l;
		int count = 0;
		while (true) {
			count++;
			if(count%1000 == 0){
				System.out.println(count);
			}
			long factor = (int) (Math.random() * 1000000000);   
			long start2 = 1;
			long startPrev = 1;
			for (int a = 0; a < 1000; a++) {
				startPrev = start2;
				start2 = start2 * factor;

				//System.out.print(start2 + " ");
				if (start2 < startPrev) {
					break;
				}
				if ((start2 / factor) != startPrev && start2 < end) {
					System.out.println("we have a hack " + factor);
					System.exit(0);
				}
			}
			//System.out.println();
		}
	}

}
