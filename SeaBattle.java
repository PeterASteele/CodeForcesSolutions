import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
//http://codeforces.com/contest/738/problem/D
public class SeaBattle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner input = new FastScanner();
		int length = input.nextInt();
		int numShips = input.nextInt();
		int lengthOfShips = input.nextInt();
		int numberOfShotsAlreadyMade = input.nextInt();
		boolean[] attacked = new boolean[length];
		String in = input.next();
		for(int a =  0; a < length; a++){
			attacked[a] = in.charAt(a)=='1';
		}
		ArrayList<Integer> spots = new ArrayList<Integer>();
		int conseq = 0;
		for(int a = 0; a < length; a++){
			if(attacked[a] == false){
				conseq++;
			}
			else{
				conseq = 0;
			}
			if(conseq == lengthOfShips){
				conseq = 0;
				spots.add(a);
			}
		}
		int numToShoot = Math.max(spots.size()-numShips+1, 0);
		StringBuilder output = new StringBuilder();
		output.append(numToShoot + "\n");
		for(int a = 0; a < numToShoot; a++){
			output.append((spots.get(a)+1) + " ");
		}
		output.append("\n");
		System.out.print(output);
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
