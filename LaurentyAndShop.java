import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/586/problem/B
public class LaurentyAndShop {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int log = 0;
		int number = input.nextInt();
		int[] topRow = new int[number - 1];
		int[] bottomRow = new int[number - 1];
		int[] vertical = new int[number];
		for (int a = 0; a < number - 1; a++) {
			topRow[a] = input.nextInt();
		}
		for (int a = 0; a < number - 1; a++) {
			bottomRow[a] = input.nextInt();
		}
		for (int a = 0; a < number; a++) {
			vertical[a] = input.nextInt();
		}
		int[] speeds = new int[number];
		for(int a = 0; a < number; a++){
			int count = 0;
			//System.out.println("adding the vertical " + vertical[a]);
			count += vertical[a];
			for(int b = 0; b < a; b++){

				//System.out.println("adding the top " + bottomRow[b]);
				count += topRow[b];
			}
			for(int b = a; b < number-1; b++){

				//System.out.println("adding the bottom " + topRow[b]);
				count += bottomRow[b];
			}
			//System.out.println(count);
			speeds[a] = count;
		}
		Arrays.sort(speeds);
		//System.out.println(Arrays.toString(speeds));
		System.out.println(speeds[0] + speeds[1]);
		/*
		int[][] adjacencyList = new int[2 * number][2 * number];
		for(int a = 0; a < 2*number; a++){
			for(int b = 0; b < 2*number; b++){
				adjacencyList[a][b] = Integer.MAX_VALUE/4;
			}
		}
		for (int a = 0; a < number-1; a++) {
			adjacencyList[2 * a][2 * a + 1] = vertical[a];
			adjacencyList[2 * a + 1][2 * a] = vertical[a];
			adjacencyList[2 * a][2 * a + 2] = topRow[a];
			adjacencyList[2 * a + 2][2 * a] = topRow[a];
			adjacencyList[2 * a + 1][2 * a + 3] = bottomRow[a];
			adjacencyList[2 * a + 3][2 * a + 1] = bottomRow[a];
		}
		for(int a = 0; a < 2*number; a++){
			for(int b = 0; b < 2*number; b++){
				System.out.print(2*adjacencyList[a][b] + "\t");
			}
			System.out.println();
		}
		
		
		for(int a = 0; a < 2*number; a++){
			for(int b = 0; b < 2*number; b++){
				for(int c = 0; c < 2*number; c++){
					if(adjacencyList[b][a] + adjacencyList[a][c] < adjacencyList[b][c]){
						adjacencyList[b][c] = adjacencyList[b][a] + adjacencyList[a][c];
					}
				}
			}
		}
		System.out.println(2*adjacencyList[0][2*number-1]);
		*/
	}

	// ////Fastscanner class.
	public static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(Reader in) {
			br = new BufferedReader(in);
		}

		public Scanner() {
			this(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		// Slightly different from java.util.Scanner.nextLine(),
		// which returns any remaining characters in current line,
		// if any.
		String readNextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
