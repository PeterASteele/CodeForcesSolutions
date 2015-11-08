
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/584/problem/D
public class DimaAndLisa {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int n = input.nextInt();
		if(isPrime(n)){
			System.out.println(1);
			System.out.println(n);	
			return;
		}
		if(isPrime(n-2)){
			System.out.println(2);
			System.out.println(2 + " " + (n-2));
			return;
		}
		int even = n - 3;
		for(int a = 3; a < even; a++){
			if(isPrime(a)){
				if(isPrime(even-a)){
					System.out.println(3);
					System.out.println(3 + " " + a + " " + (even-a));
					return;
				}
			}
		}
		
	}
	
	
	private static boolean isPrime(int input) {
		for(int a = 2; a <= Math.sqrt(input); a++){
			if(input % a == 0){
				return false;
			}
		}
		return true;
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
