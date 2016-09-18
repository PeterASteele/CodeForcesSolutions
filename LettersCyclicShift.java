import java.util.Scanner;
//http://codeforces.com/problemset/problem/708/A
public class LettersCyclicShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		int firstNonA = -1;

		for (int a = 0; a < in.length(); a++) {
			if (in.charAt(a) != 'a') {
				firstNonA = a;
				break;
			}
		}
		if (firstNonA == -1) {
			// special case for all A
			StringBuilder output = new StringBuilder();
			for (int a = 0; a < in.length() - 1; a++) {
				output.append('a');
			}
			output.append('z');
			System.out.println(output);
		} else {
			int shiftSize = 25;
			StringBuilder output = new StringBuilder();
			for (int a = 0; a < firstNonA; a++) {
				output.append(in.charAt(a));
			}
			int start = firstNonA;
			while (in.charAt(start) != 'a') {
				output.append((char) (in.charAt(start) - 1));
				start++;
				if (start == in.length()) {
					break;
				}
			}
			while (start != in.length()) {
				output.append(in.charAt(start));
				start++;
			}
			System.out.println(output);
		}
	}

}