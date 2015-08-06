import java.util.Scanner;


public class Lineland_Mail {
	/*
	 * A. Lineland Mail
time limit per test3 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
All cities of Lineland are located on the Ox coordinate axis. Thus, each city is associated with its position xi — a coordinate on the Ox axis. No two cities are located at a single point.

Lineland residents love to send letters to each other. A person may send a letter only if the recipient lives in another city (because if they live in the same city, then it is easier to drop in).

Strange but true, the cost of sending the letter is exactly equal to the distance between the sender's city and the recipient's city.

For each city calculate two values ​​mini and maxi, where mini is the minimum cost of sending a letter from the i-th city to some other city, and maxi is the the maximum cost of sending a letter from the i-th city to some other city

Input
The first line of the input contains integer n (2 ≤ n ≤ 10^5) — the number of cities in Lineland. The second line contains the sequence of n distinct integers x1, x2, ..., xn ( - 10^9 ≤ xi ≤ 10^9), where xi is the x-coordinate of the i-th city. All the xi's are distinct and follow in ascending order.

Output
Print n lines, the i-th line must contain two integers mini, maxi, separated by a space, where mini is the minimum cost of sending a letter from the i-th city, and maxi is the maximum cost of sending a letter from the i-th city.
	 */
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numberCases = input.nextInt();
		int[] inputArray = new int[numberCases];
		for(int a = 0; a < numberCases; a++){
			inputArray[a] = input.nextInt();
		}
		input.nextLine();
		System.out.println(Math.abs(inputArray[1] - inputArray[0]) + " " + Math.abs(inputArray[numberCases-1] - inputArray[0]));
	
		for(int a = 1; a < numberCases - 1; a++){
			int min = Math.min(Math.abs(inputArray[a] - inputArray[a-1]), Math.abs(inputArray[a] - inputArray[a+1]));
			int max = Math.max(Math.abs(inputArray[a] - inputArray[0]), Math.abs(inputArray[a] - inputArray[numberCases-1]));
			System.out.println(min + " " + max);
		}
		System.out.println(Math.abs(inputArray[numberCases-1] - inputArray[numberCases-2]) + " " + Math.abs(inputArray[numberCases-1] - inputArray[0]));
		
	}	
}
