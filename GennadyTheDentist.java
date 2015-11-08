import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/586/problem/C
public class GennadyTheDentist {
	public static void main(String[] args) {
		Scanner input = new Scanner();
		long number = input.nextLong();
		long[] confidence = new long[(int) number];
		long[] dentistCry = new long[(int) number];
		long[] hallCry = new long[(int) number];
		long[] id = new long[(int) number];
		long[] shift = new long[(int) number];
		for (int a = 0; a < number; a++) {
			dentistCry[a] = input.nextInt();
			hallCry[a] = input.nextInt();
			confidence[a] = input.nextInt();
			id[a] = a + 1;
			shift[a] = 0;
		}
		long lineSize = number;

		ArrayList<Long> treated = new ArrayList<Long>();
		//System.out.println(lineSize);
		//System.out.println(Arrays.toString(id));
		while (lineSize != 0) {
			treated.add(id[0]);
			long tempDentistNoise = dentistCry[0];
			long cumulativeNoise = 0;
			int numShift = 1;
			for (int a = 1; a < lineSize; a++) {
				// System.out.println("a is " + a + " with confidence " +
				// confidence[a]);
				if (tempDentistNoise >= 0) {
					confidence[a] -= tempDentistNoise;
				}
				confidence[a] -= cumulativeNoise;
				// System.out.println(confidence[a] + " is the confidence ");
				if (confidence[a] < 0) {
					cumulativeNoise += hallCry[a];
					// System.out.println("noise increases by " + hallCry[a]);
					// System.out.println("total noise: " + (cumulativeNoise +
					// tempDentistNoise-1));
					numShift++;
					hallCry[a] = -1 * numShift;
				}
				shift[a] = numShift;
				tempDentistNoise--;
			}
			lineSize -= numShift;
			long[] tempconfidence = confidence.clone();
			long[] tempdentistCry = dentistCry.clone();
			long[] temphallCry = hallCry.clone();
			long[] tempid = id.clone();
			long[] tempshift = shift.clone();
			long total = 0;
			if (lineSize != 0) {
				for (int a = (int) number - 1; a > 0; a--) {
					if(temphallCry[a] > 0 && a != 0){
						
						confidence[ (int) (a - tempshift[a])] = tempconfidence[a];
						dentistCry[ (int) (a - tempshift[a])] = tempdentistCry[a];
						hallCry[(int) (a - tempshift[a])] = temphallCry[a];
						id[(int) (a - tempshift[a])] = tempid[a];
						shift[(int) (a - tempshift[a])] = 0;
					}
				}
			}
			//System.out.println(lineSize);
			//System.out.println(Arrays.toString(id));
		}
		System.out.println(treated.size());
		for(Long a:treated){
			System.out.print(a + " ");
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
