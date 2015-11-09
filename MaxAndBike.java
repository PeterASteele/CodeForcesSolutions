import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class MaxAndBike {
//http://codeforces.com/contest/595/problem/C
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numberOfComp = input.nextInt();
		int radius = input.nextInt();
		int v = input.nextInt();
		int[] compStart = new int[numberOfComp];
		int[] compEnd = new int[numberOfComp];
		for (int a = 0; a < numberOfComp; a++) {
			compStart[a] = input.nextInt();
			compEnd[a] = input.nextInt();
		}
		for (int a = 0; a < numberOfComp; a++) {
			double turnfrac = (compEnd[a] - compStart[a])
					/ (2 * Math.PI * radius);
			int totalTurns = (int) turnfrac;
			double extraDistance = (turnfrac - totalTurns)
					* (2 * Math.PI * radius);
			double x0 = binarySearch((x) -> radius * x + 2 * Math.sin(x/2.0) * radius, 0, 2*Math.PI, extraDistance);
			double totalTurnsAnswer = x0/(2*Math.PI) + totalTurns;
			double fakeDistance = totalTurnsAnswer * 2 * Math.PI * radius;
			double time = fakeDistance/v;
			System.out.println(time);
		}
	}

	static double binarySearch(Function<Double, Double> f, double low,
			double high, double y) {
		while (Math.ulp(low) < (high - low)) {
			double mid = (low + high) / 2.0;
			double midVal = f.apply(mid);

			if (midVal == y) // unlikely, but possible
				return mid;
			else if (midVal < y)
				low = mid;
			else if (midVal > y)
				high = mid;
		}
		return (low + high) / 2.0;
	}

	/* Outputs 10.000000 */
	
	// System.out.printf("%.6f%n", x0);

}
