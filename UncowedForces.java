import java.util.Scanner;
//http://codeforces.com/contest/604/problem/A
public class UncowedForces {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] timeSubmit = new int[5];
		int[] wrongSubmit = new int[5];
		int goodHacks = -1;
		int badHacks = -1;
		for(int a = 0; a < 5; a++){
			timeSubmit[a] = input.nextInt();
		}
		for(int a = 0; a < 5; a++){
			wrongSubmit[a] = input.nextInt();
		}
		goodHacks = input.nextInt();
		badHacks = input.nextInt();
		int[] scoreArray = new int[5];
		scoreArray[0] = 500;
		scoreArray[1] = 1000;
		scoreArray[2] = 1500;
		scoreArray[3] = 2000;
		scoreArray[4] = 2500;
		double totalScore = 0;
		for(int a = 0; a < 5; a++){
			totalScore += Math.max(.3 * scoreArray[a], (1-timeSubmit[a]/250.0)*scoreArray[a] - 50 * wrongSubmit[a]);
		}
		totalScore += 100 * goodHacks;
		totalScore += -50 * badHacks;
		System.out.println((int) (totalScore+ 0.001));
	}

}
