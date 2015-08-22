import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * C. Replacement
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Daniel has a string s, consisting of lowercase English letters and period signs (characters '.'). Let's define the operation of replacement as the following sequence of steps: find a substring ".." (two consecutive periods) in string s, of all occurrences of the substring let's choose the first one, and replace this substring with string ".". In other words, during the replacement operation, the first two consecutive periods are replaced by one. If string s contains no two consecutive periods, then nothing happens.

Let's define f(s) as the minimum number of operations of replacement to perform, so that the string does not have any two consecutive periods left.

You need to process m queries, the i-th results in that the character at position xi (1 ≤ xi ≤ n) of string s is assigned value ci. After each operation you have to calculate and output the value of f(s).

Help Daniel to process all queries.

Input
The first line contains two integers n and m (1 ≤ n, m ≤ 300 000) the length of the string and the number of queries.

The second line contains string s, consisting of n lowercase English letters and period signs.

The following m lines contain the descriptions of queries. The i-th line contains integer xi and ci (1 ≤ xi ≤ n, ci — a lowercas English letter or a period sign), describing the query of assigning symbol ci to position xi.

Output
Print m numbers, one per line, the i-th of these numbers must be equal to the value of f(s) after performing the i-th assignment.
 */
public class Replacement {
	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		// Scanner input = new Scanner(System.in);
		try {
			String first2Inputs = input.readLine();
			String[] firstInputs = first2Inputs.split(" ");
			int lengthOfString = Integer.parseInt(firstInputs[0]);
			int numberOfQueries = Integer.parseInt(firstInputs[1]);
			// input.nextLine();
			String inputString = input.readLine();
			int count = 0;
			for (int a = 0; a < lengthOfString - 1; a++) {
				if (inputString.charAt(a) == '.'
						&& inputString.charAt(a + 1) == '.') {
					count++;
				}
			}
			ArrayList<Integer> output = new ArrayList<Integer>();
			StringBuilder inputStringbuilder = new StringBuilder(inputString);
			for (int a = 0; a < numberOfQueries; a++) {
				String nextLine = input.readLine();
				String[] line = nextLine.split(" ");
				int temp = Integer.parseInt(line[0]);
				String replaceLine = line[1];
				char replaceChar = replaceLine.charAt(0);
				boolean isPeriod = inputStringbuilder.charAt(temp - 1) == '.';

				if (replaceChar != '.' && isPeriod == true) { // if we are
																// removing a
																// period
					inputStringbuilder.setCharAt(temp - 1, replaceChar);
					boolean isPeriodLeft = false;
					boolean isPeriodRight = false;
					if (temp != 1) {
						if (inputStringbuilder.charAt(temp - 2) == '.') {
							isPeriodLeft = true;
						}
					}
					if (temp != lengthOfString) {
						if (inputStringbuilder.charAt(temp) == '.') {
							isPeriodRight = true;
						}
					}
					if (isPeriod) {
						if (isPeriodLeft || isPeriodRight) {
							count--; // if there is a period, we lose one.
						}
						if (isPeriodLeft && isPeriodRight) {
							count--; // if there is one on both sides, we lose
										// 2!
						}
					}
				}
				if (replaceChar == '.' && isPeriod == false) {
					inputStringbuilder.setCharAt(temp - 1, replaceChar);
					boolean isPeriodLeft = false;
					boolean isPeriodRight = false;
					if (temp != 1) {
						if (inputStringbuilder.charAt(temp - 2) == '.') {
							isPeriodLeft = true;
						}
					}
					if (temp != lengthOfString) {
						if (inputStringbuilder.charAt(temp) == '.') {
							isPeriodRight = true;
						}
					}
					if (!isPeriod) {
						if (isPeriodLeft || isPeriodRight) {
							count++; // if there is a period, we lose one.
						}
						if (isPeriodLeft && isPeriodRight) {
							count++; // if there is one on both sides, we lose
										// 2!
						}
					}
				}
				output.add(count);
			}
			for (Integer a : output) {
				System.out.println(a);
			}
		} catch (Exception e) {

		}
	}
}
