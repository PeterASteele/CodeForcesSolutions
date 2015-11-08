
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OlesyaAndRodion {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int N = input.nextInt();
		int T = input.nextInt();
		if(T == 10 && N == 1){
			System.out.println(-1);
			return;
		}
		int temp = 0;
		if(N > 9){
			temp = N - 9;
			N = 9;
		}
		int magT = (int) (Math.log(T)/Math.log(10));
		int answer = (int) (Math.pow(10, N-1)/Math.pow(10, magT)*T);
		System.out.print(answer);
		for(int a = 0; a < temp; a++){
			System.out.print("0");
		}
		System.out.println();
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
