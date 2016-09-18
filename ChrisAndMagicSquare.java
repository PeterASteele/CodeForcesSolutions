import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/711/E
public class ChrisAndMagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long[][] grid = new long[n][n];
		int xCor = -1;
		int yCor = -1;
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				grid[a][b] = input.nextLong();
				if (grid[a][b] == 0) {
					xCor = a;
					yCor = b;
				}
			}
		}
		if (n == 1) {
			System.out.println("1");
		} else {
			int safeRow = (xCor - 1 + n) % n; // row that doesn't have 0
			long goal = 0;
			for (int a = 0; a < n; a++) {
				goal += grid[safeRow][a];
			}

			long rowSum = 0;
			for (int a = 0; a < n; a++) {
				rowSum += grid[xCor][a];
			}
			long answer = goal - rowSum;
			grid[xCor][yCor] = answer;

			boolean isValid = true;
			for (int a = 0; a < n; a++) {
				long sum1 = 0;
				long sum2 = 0;
				for (int b = 0; b < n; b++) {
					sum1 += grid[a][b];
					sum2 += grid[b][a];
				}
				isValid = isValid && (sum1 == goal);
				isValid = isValid && (sum2 == goal);
			}
			long sum1 = 0;
			long sum2 = 0;
			for (int a = 0; a < n; a++) {
				sum1 += grid[a][a];
				sum2 += grid[a][n - a - 1];
			}
			isValid = isValid && (sum1 == goal);
			isValid = isValid && (sum2 == goal);

			if ((answer > 0) && isValid) {
				System.out.println(answer);
			} else {
				System.out.println(-1);
			}

		}
	}
}