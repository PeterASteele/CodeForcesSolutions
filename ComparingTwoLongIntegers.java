import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

//http://codeforces.com/contest/616/problem/A
public class ComparingTwoLongIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner();
		String a = input.readNextLine();
		String b = input.readNextLine();
		int lengthA = a.length();
		int lengthB = b.length();
		int goalLength = Math.max(lengthA, lengthB);
		StringBuilder newA = new StringBuilder();
		StringBuilder newB = new StringBuilder();
		for(int d = lengthA; d < goalLength; d++){
			newA.append("0");
		}
		newA.append(a);
		for(int d = lengthB; d < goalLength; d++){
			newB.append("0");
		}
		newB.append(b);
		
		int result = newA.toString().compareTo(newB.toString());
		
		if(result > 0){
			System.out.println(">");
		}
		if(result < 0){
			System.out.println("<");
		}
		if(result == 0){
			System.out.println("=");
		}
	}
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
