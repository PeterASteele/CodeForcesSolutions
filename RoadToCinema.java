import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/738/problem/C
public class RoadToCinema {
	static long[] gasStationArray;
	static long timeFilmStarts;
	static long lengthOfRoad;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner input = new FastScanner();
		int numberOfCars = input.nextInt();
		int numberOfGasStations = input.nextInt();
		lengthOfRoad = input.nextInt();
		timeFilmStarts = input.nextInt();

		long[] price = new long[numberOfCars];
		long[] fuel = new long[numberOfCars];
		for (int a = 0; a < numberOfCars; a++) {
			price[a] = input.nextInt();
			fuel[a] = input.nextInt();
		}

		gasStationArray = new long[numberOfGasStations + 2];
		for (int a = 0; a < numberOfGasStations; a++) {
			gasStationArray[a] = input.nextInt();
		}
		gasStationArray[numberOfGasStations] = lengthOfRoad;
		gasStationArray[numberOfGasStations + 1] = 0;
		badshuffle(gasStationArray);
		Arrays.sort(gasStationArray);

		double fuelNeeded = binarySearch(0, 1E11, 1);
		// System.out.println(Arrays.toString(gasStationArray));
		long realFuelNeeded = Math.round(fuelNeeded);
		// System.out.println(realFuelNeeded);
		long cheapestPrice = Long.MAX_VALUE;
		for (int a = 0; a < numberOfCars; a++) {
			if (fuel[a] >= realFuelNeeded) {
				if (price[a] < cheapestPrice) {
					cheapestPrice = price[a];
				}
			}
		}
		if (cheapestPrice == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(cheapestPrice);
		}
	}

	private static void badshuffle(long[] gasStationArray) {
		for (int a = 0; a < 100000; a++) {
			int x = (int) (Math.random() * gasStationArray.length);
			int y = (int) (Math.random() * gasStationArray.length);
			long temp = gasStationArray[x];
			gasStationArray[x] = gasStationArray[y];
			gasStationArray[y] = temp;
		}
	}

	/**
	 * Return x in [a, b] such that f(x) = y. f() must be monotonically
	 * increasing. Also known as bisection method.
	 */
	static double binarySearch(double low, double high, double y) {
		// avoid excessive iterations when root is at 0.0
		while ((high - low) > Math.max(1e-16, 10 * Math.ulp(high))) {
			double mid = (low + high) / 2.0;
			double midVal = apply(mid);
			if (midVal < y) // or <=, see below.
				low = mid;
			else
				high = mid;
		}
		return (low + high) / 2.0;
	}

	static double apply(double fuelCapacity) {
		// check if this amount of fuel is good
		double timeTillDestination = 0;
		for (int a = 1; a < gasStationArray.length; a++) {
			double gap = gasStationArray[a] - gasStationArray[a - 1];
			if (gap > fuelCapacity + 100 * Math.ulp(fuelCapacity)) {
				return 0;
			}
			if (gap < fuelCapacity / 2) {
				timeTillDestination += gap;
			} else {
				timeTillDestination += gap;
				timeTillDestination += (2 * gap - fuelCapacity);
			}
		}
//		 System.out.println(fuelCapacity + " " + timeTillDestination);
		return ((timeTillDestination - 100 * Math.ulp(timeTillDestination)) > timeFilmStarts) ? 0
				: 1;
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
