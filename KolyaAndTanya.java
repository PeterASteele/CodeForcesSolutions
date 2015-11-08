
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/584/problem/B
public class KolyaAndTanya {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int N = input.nextInt();
		long total = 1;
		long total2 = 1;
		for(int a = 0; a < N; a++){
			total = total * 27;
			total = total % 1000000007;

			total2 = total2 * 7;
			total2 = total2 % 1000000007;
		}
		long answer = (total - total2 + 1000000007)%1000000007;
		System.out.println(answer);
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
