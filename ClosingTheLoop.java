import java.io.*;

import java.util.StringTokenizer;
import java.util.*;
//http://codeforces.com/gym/101090/attachments
public class ClosingTheLoop {
	public static void main(String[] args){
		FastScanner input = new FastScanner();
		int n = input.nextInt();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for(int a = 0; a < n; a++){
			String in = input.next(); 
			String front = in.substring(0, in.length()-1);
			char end = in.charAt(in.length()-1);
			if(end == 'B'){
				list1.add(Integer.parseInt(front)-1);
			}
			else{
				list2.add(Integer.parseInt(front)-1);
			}
		}
		Collections.sort(list1);
		Collections.reverse(list1);
		Collections.sort(list2);
		Collections.reverse(list2);
		long sum = 0;
		for(int a = 0; a < Math.min(list1.size(), list2.size()); a++){
			sum += list1.get(a) + list2.get(a);
		}
		System.out.println(sum);
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