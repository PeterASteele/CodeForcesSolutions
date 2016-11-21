import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/738/problem/B
public class Spotlights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner input = new FastScanner();
		int n = input.nextInt();
		int m = input.nextInt();
		boolean[][] arr = new boolean[n][m];
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				arr[a][b] = input.nextInt() == 1 ? true : false;
			}
		}
		int[] leftIdx = new int[n];
		for (int a = 0; a < n; a++) {
			leftIdx[a] = Integer.MAX_VALUE;
			for (int b = 0; b < m; b++) {
				if (arr[a][b]) {
					leftIdx[a] = b;
					break;
				}
			}
		}
		int[] rightIdx = new int[n];
		for (int a = 0; a < n; a++) {
			rightIdx[a] = Integer.MIN_VALUE;
			for (int b = m - 1; b >= 0; b--) {
				if (arr[a][b]) {
					rightIdx[a] = b;
					break;
				}
			}
		}
		int[] upIdx = new int[m];

		for (int b = 0; b < m; b++) {
			upIdx[b] = Integer.MAX_VALUE;
			for (int a = 0; a < n; a++) {
				if (arr[a][b]) {
					upIdx[b] = a;
					break;
				}
			}
		}
		int[] downIdx = new int[m];
		for (int b = 0; b < m; b++) {
			downIdx[b] = Integer.MIN_VALUE;
			for (int a = n - 1; a >= 0; a--) {
				if (arr[a][b]) {
					downIdx[b] = a;
					break;
				}
			}
		}
		int sum = 0;
		for (int a = 0; a < n; a++) {
			for(int b = 0; b < m; b++){
				if(!arr[a][b]){
					if(upIdx[b] < a){
						sum++;
					}
					if(downIdx[b] > a){
						sum++;
					}
					if(leftIdx[a] < b){
						sum++;
					}
					if(rightIdx[a] > b){
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
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
