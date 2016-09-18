import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

//http://codeforces.com/gym/101090/attachments

public class Pair {
	public static void main(String[] args){
		FastScanner input = new FastScanner();
		int n = input.nextInt(); int k = input.nextInt();
		int[] contains = new int[n+1];
		for(int a = 0; a < k; a++){
			contains[input.nextInt()] = a+1;
		}
		for(int b = 1; b <= n; b++){
			if(contains[b] != 0){
				for(int c =b+b; c <= n; c+= b){
					if(contains[c] != 0){
						System.out.println(Math.min(contains[b], contains[c]) + " " + Math.max(contains[b], contains[c]));
						return;
					}
				}
			}
		}
		System.out.println(0 + " " + 0);
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