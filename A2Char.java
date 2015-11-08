
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/593/problem/A
public class A2Char {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int distance = input.nextInt();
		
		ArrayList<String> inputStrings = new ArrayList<String>();
		for(int a = 0; a < distance; a++){
			inputStrings.add(input.readNextLine());
		}
		int max = 0;
		for(int a = 0; a < 26; a++){
			for(int b = a+1; b < 26; b++){
				int total = 0;
				for(String temp:inputStrings){
					boolean OK = true;
					for(int c = 0; c < temp.length(); c++){
						if(!(temp.charAt(c) == (('a') + a) || temp.charAt(c) == (('a') + b))){
							OK = false;
							break;
						}
					}
					if(OK){
						total = total + temp.length();
					}
				}
				if(total > max){
					max = total;
				}
			}
		}	
		System.out.println(max);
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
