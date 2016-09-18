import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;


//http://codeforces.com/gym/101090/attachments
public class Selection {
	public static void main(String[] args){
		FastScanner input = new FastScanner();
		int n = input.nextInt();
		long numEvens = n/2;
		long numOdds = n/2 + n%2;
		
		long threeEvens = numEvens * (numEvens-1) * (numEvens-2)/6;
		long twoOddsOneEven = numEvens * numOdds * (numOdds - 1)/2;
		System.out.println((threeEvens + twoOddsOneEven));
		
		
		
	}
	 public static class FastScanner {
	        BufferedReader br;
	        StringTokenizer st;

	        public FastScanner (Reader in) {
	            br = new BufferedReader(in);
	        }

	        public FastScanner () { this(new InputStreamReader(System.in)); }

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

	        int nextInt() { return Integer.parseInt(next()); }
	        long nextLong() { return Long.parseLong(next()); }
	        double nextDouble() { return Double.parseDouble(next()); }

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