import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;

//http://codeforces.com/contest/738/problem/E
public class Subordinates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner input = new FastScanner();
		int n = input.nextInt();
		int chiefId = input.nextInt()-1;
		int[] arr = new int[n];
		for(int a = 0; a < n; a++){
			arr[a] = input.nextInt();
		}
		
		
		int mistake = 0;
		if(arr[chiefId] != 0){
			arr[chiefId] = 0;
			mistake++;
		}
		
		int mistakeBank = 0;
		int chiefCount = 0;
		int allowedWrongEnd = 0;
		for(int a = 0; a < n; a++){
			if(arr[a] == 0){
				chiefCount++;
			}
		}
		mistake += chiefCount-1;
		mistakeBank += chiefCount-1;
		allowedWrongEnd += chiefCount-1;
		int[] freqDist = new int[200001];
		for(int a = 0; a < arr.length; a++){
			freqDist[arr[a]]++;
		}
		int count = 1;
		for(int a = 1; a < arr.length; a++){
//			System.out.println(count + " " + allowedWron);
			if(count + allowedWrongEnd >= n){
				break;
			}
			if(freqDist[a] == 0){
				if(mistakeBank > 0){
					mistakeBank--; //take one of the leftover chiefs
				}
				else{
					mistake++;
					allowedWrongEnd++;
				}
			}
			else{
				count += freqDist[a];
			}
		}
//		System.out.println(count + " " + allowedWrongEnd + " " + mistakeBank);
		System.out.println(mistake);
		
	}
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(Reader in) {
			br = new BufferedReader(in);
		}

		public FastScanner() {
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

		String readNextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] readIntArray(int n) {
			int[] a = new int[n];
			for (int idx = 0; idx < n; idx++) {
				a[idx] = nextInt();
			}
			return a;
		}

		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int idx = 0; idx < n; idx++) {
				a[idx] = nextLong();
			}
			return a;
		}
	}
}
