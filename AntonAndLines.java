import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class AntonAndLines {
	//http://codeforces.com/contest/593/problem/B
	public static void main(String[] args) {
		Scanner input = new Scanner();
		int distance = input.nextInt();
		TreeMap<Double, SpecialPoint> bigMap = new TreeMap<Double, SpecialPoint>();
		int lowBound = input.nextInt();
		int upperBound = input.nextInt();
		boolean OK = true;
		for(int a = 0; a < distance; a++){
			int tempSlope = input.nextInt();
			int tempIntercept = input.nextInt();
			double[] output = lineToY(tempSlope, tempIntercept, lowBound, upperBound);
			if(bigMap.containsKey(output[0])){
				boolean OK2 = bigMap.get(output[0]).addPoint(output[1]);
				if(OK2 == false){
					OK = false;
					break;
				}
			}
			else{
				bigMap.put(output[0], new SpecialPoint(output[1]));
			}
			if(bigMap.lowerEntry(output[0]) != null && bigMap.lowerEntry(output[0]).getValue().yMax > output[1]){
				OK = false;
				break;
			}
			if(bigMap.higherEntry(output[0]) != null && bigMap.higherEntry(output[0]).getValue().yMin < output[1]){
				OK = false;
				break;
			}
		}
		if(OK){
			System.out.println("NO");
		}
		else{
			System.out.println("YES");
		}
	}
	public static double[] lineToY(int m, int b, int x1, int x2){
		double[] output = new double[2];
		long m2 = m;
		long b2 = b;
		long x12 = x1;
		long x22 = x2;
		
		output[0] = x12 * m2 + b2;
		output[1] = x22 * m2 + b2;
		return output;
	}
	public static class SpecialPoint {
		double yMin;
		double yMax;
		public SpecialPoint(double y) {
			this.yMin = y;
			this.yMax = y;
		}
		public boolean addPoint(double y) {
			if(yMin == y || yMax == y){
				return false;
			}
			if (yMin > y) {
				yMin = y;
			}
			if (yMax < y) {
				yMax = y;
			}
			return true;
		}
	}

	// ////Fastscanner class.
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
