
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/586/problem/A
public class AlenaSchedule {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int log = 0;
		int number = input.nextInt();
		int[] inputs = new int[number];
		int[] inputs2 = new int[number];
		for(int a = 0; a < number; a++){
			inputs[a] = input.nextInt();
			inputs2[a] = inputs[a];
		}
		for(int a = 1; a < number-1; a++){
			if(inputs[a-1] == 1 && inputs[a+1] == 1){
				inputs2[a] = 1;
			}
		}
		int count = 0;
		for(int a = 0; a < number; a++){
			count += inputs2[a];
		}
		System.out.println(count);
	}

	//////Fastscanner class.
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
