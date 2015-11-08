
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MarinaAndVasya {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int n = input.nextInt();
		int difference = input.nextInt();
		String s1 = input.readNextLine();
		String s2 = input.readNextLine();
		if(difference > n){
			System.out.println(-1);
			return;
		}
		int sharedCharacters = getNumSharedCharacters(s1, s2);
		int minDiff = (int)(((n - sharedCharacters)/2.0) + .51);
		if(difference < minDiff){
			System.out.println(-1);
			return;
		}

		int splitCharacters = n-sharedCharacters;
		StringBuilder answer = new StringBuilder();
		int equals = difference - splitCharacters;
		if(equals < 0){
			equals = 0;
		}
		int currentEquals = 0;

		int bothMax = 2 * difference - splitCharacters;
		int leftMax = difference - bothMax;
		int rightMax = difference - bothMax;
		int left = 0;
		int right = 0;
		int both = 0;
		for(int a = 0; a < n; a++){
			if(s1.charAt(a) == s2.charAt(a)){
				if(currentEquals < equals){ //handles the case we must use the equal elements of strings
					currentEquals++;
					answer.append(getDifferentChar(s1.charAt(a), s2.charAt(a)));
				}
				else{
					answer.append(s1.charAt(a));
				}
			}
			else{ //if not, we can just use the normal elements.
				if(both < bothMax){
					both++;
					answer.append(getDifferentChar(s1.charAt(a), s2.charAt(a)));
				}
				else if(left < leftMax){
					left++;
					answer.append(s1.charAt(a));
				}
				else if(right < rightMax){
					right++;
					answer.append(s2.charAt(a));
				}
			}
		}
		System.out.println(answer);
	}

	private static int getNumSharedCharacters(String s1, String s2) {
		int count = 0;
		for(int a = 0; a < s1.length(); a++){
			if(s1.charAt(a) == s2.charAt(a)){
				count++;
			}
		}
		return count;
	}
	public static char getDifferentChar(char a, char b){
		if(a != 'a' && b != 'a'){
			return 'a';
		}
		if(a != 'b' && b != 'b'){
			return 'b';
		}
		return 'c';		
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
