import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//http://codeforces.com/problemset/problem/706/E
public class WorkingRoutine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner input = new FastScanner();
		int n = input.nextInt();
		int m = input.nextInt();
		int q = input.nextInt();

		Cell[][] start = new Cell[n + 2][m + 2];
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= m; b++) {
				start[a][b] = new Cell(input.nextInt());
			}
		}
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= m; b++) {
				start[a][b].up = start[a - 1][b];
				start[a][b].down = start[a + 1][b];
				start[a][b].left = start[a][b - 1];
				start[a][b].right = start[a][b + 1];
			}
		}
		for (int a = 0; a < m + 2; a++) {
			Cell temp = new Cell(-1);
			start[0][a] = temp;
			Cell temp2 = new Cell(-1);
			start[n + 1][a] = temp2;
		}
		for (int a = 0; a < n + 2; a++) {
			Cell temp = new Cell(-1);
			start[a][0] = temp;
			Cell temp2 = new Cell(-1);
			start[a][m + 1] = temp2;
		}

		// fix edges
		for (int a = 0; a < m + 2; a++) {
			start[0][a].down = start[1][a];
			start[1][a].up = start[0][a];
			start[n + 1][a].up = start[n][a];
			start[n][a].down = start[n + 1][a];
			if (a != m + 1) {
				start[0][a].right = start[0][a + 1];
				start[0][a + 1].left = start[0][a];
				start[n + 1][a].right = start[n + 1][a + 1];
				start[n + 1][a + 1].left = start[n + 1][a];
			}
		}
		for (int a = 0; a < n + 2; a++) {
			start[a][0].right = start[a][1];
			start[a][1].left = start[a][0];
			start[a][m + 1].left = start[a][m];
			start[a][m].right = start[a][m + 1];
			if (a != n + 1) {
				start[a][0].down = start[a + 1][0];
				start[a + 1][0].up = start[a][0];
				start[a][m + 1].down = start[a + 1][m + 1];
				start[a + 1][m + 1].up = start[a][m + 1];
			}
		}

		Cell lowerLeft = start[0][0];

		for (int a = 0; a < q; a++) {
			int y1 = input.nextInt();
			int x1 = input.nextInt();
			int y2 = input.nextInt();
			int x2 = input.nextInt();
			int h = input.nextInt();
			int w = input.nextInt();

			// we need to slice out the section, and move it.
			Cell start1 = move(x1, y1, lowerLeft);
			Cell start2 = move(x2, y2, lowerLeft);
			slide(start1, start2, w, h);
		}

		Cell tmp = lowerLeft.down;

		StringBuilder output = new StringBuilder();
		for (int a = 1; a < n + 1; a++) {
			Cell tmpHorizontal = tmp;
			tmpHorizontal = tmpHorizontal.right;
			
			for (int b = 1; b < m + 1; b++) {
				output.append(tmpHorizontal.value + " ");
				tmpHorizontal = tmpHorizontal.right;
			}
			tmp = tmp.down;
			output.append("\n");
		}
		System.out.print(output);
	}

	private static void slide(Cell start1, Cell start2, int w, int h) {
		Cell startOuter1 = start1.up;
		Cell startInner1 = start1;
		Cell startOuter2 = start2.up;
		Cell startInner2 = start2;

		Cell[] swapOuter1 = new Cell[w+w+h+h];
		Cell[] swapOuter2 = new Cell[w+w+h+h];
		Cell[] swapInner1 = new Cell[w+w+h+h];
		Cell[] swapInner2 = new Cell[w+w+h+h];
		// top
		for (int a = 0; a < w; a++) {
			// move 4 pointers
			swapOuter1[a] = startOuter1;
			swapOuter2[a] = startOuter2;
			swapInner1[a] = startInner1;
			swapInner2[a] = startInner2;

			// move over 1
			if (a != w - 1) {
				startOuter1 = startOuter1.right;
				startOuter2 = startOuter2.right;
				startInner1 = startInner1.right;
				startInner2 = startInner2.right;
			} else {
				startOuter1 = startOuter1.right.down;
				startOuter2 = startOuter2.right.down;
			}
			// done with the top
		}
		// right
		for (int a = 0; a < h; a++) {

			swapOuter1[w+a] = startOuter1;
			swapOuter2[w+a] = startOuter2;
			swapInner1[w+a] = startInner1;
			swapInner2[w+a] = startInner2;

			if (a != h - 1) {
				startOuter1 = startOuter1.down;
				startOuter2 = startOuter2.down;
				startInner1 = startInner1.down;
				startInner2 = startInner2.down;
			} else {
				startOuter1 = startOuter1.down.left;
				startOuter2 = startOuter2.down.left;
			}
		}

		// bottom
		for (int a = 0; a < w; a++) {
			// move 4 pointers
			swapOuter1[w+h+a] = startOuter1;
			swapOuter2[w+h+a] = startOuter2;
			swapInner1[w+h+a] = startInner1;
			swapInner2[w+h+a] = startInner2;

			// move over 1
			if (a != w - 1) {
				startOuter1 = startOuter1.left;
				startOuter2 = startOuter2.left;
				startInner1 = startInner1.left;
				startInner2 = startInner2.left;
			} else {
				startOuter1 = startOuter1.left.up;
				startOuter2 = startOuter2.left.up;
			}
		}

		// left
		for (int a = 0; a < h; a++) {

			swapOuter1[w+w+h+a] = startOuter1;
			swapOuter2[w+w+h+a] = startOuter2;
			swapInner1[w+w+h+a] = startInner1;
			swapInner2[w+w+h+a] = startInner2;

			if (a != h - 1) {
				startOuter1 = startOuter1.up;
				startOuter2 = startOuter2.up;
				startInner1 = startInner1.up;
				startInner2 = startInner2.up;
			} else {
				startOuter1 = startOuter1.up.right;
				startOuter2 = startOuter2.up.right;
			}
		}

		for (int a = 0; a < w; a++) {
			startOuter1 = swapOuter1[a];
			startOuter2 = swapOuter2[a];
			startInner1 = swapInner1[a];
			startInner2 = swapInner2[a];

			startOuter1.down = startInner2;
			startOuter2.down = startInner1;
			startInner1.up = startOuter2;
			startInner2.up = startOuter1;
		}

		for (int a = w; a < w + h; a++) {
			startOuter1 = swapOuter1[a];
			startOuter2 = swapOuter2[a];
			startInner1 = swapInner1[a];
			startInner2 = swapInner2[a];

			startOuter1.left = startInner2;
			startOuter2.left = startInner1;
			startInner1.right = startOuter2;
			startInner2.right = startOuter1;
		}

		for (int a = w + h; a < w + h + w; a++) {
			startOuter1 = swapOuter1[a];
			startOuter2 = swapOuter2[a];
			startInner1 = swapInner1[a];
			startInner2 = swapInner2[a];

			startOuter1.up = startInner2;
			startOuter2.up = startInner1;
			startInner1.down = startOuter2;
			startInner2.down = startOuter1;
		}

		for (int a = w + h + w; a < w + h + w + h; a++) {
			startOuter1 = swapOuter1[a];
			startOuter2 = swapOuter2[a];
			startInner1 = swapInner1[a];
			startInner2 = swapInner2[a];

			startOuter1.right = startInner2;
			startOuter2.right = startInner1;
			startInner1.left = startOuter2;
			startInner2.left = startOuter1;
		}

	}

	private static Cell move(int x1, int y1, Cell lowerLeft) {
		Cell tmp = lowerLeft;
		while (x1 > 0) {
			tmp = tmp.right;
			x1--;
		}
		while (x1 < 0) {
			tmp = tmp.left;
			x1++;
		}
		while (y1 > 0) {
			tmp = tmp.down;
			y1--;
		}
		while (y1 < 0) {
			tmp = tmp.up;
			y1++;
		}
		return tmp;
	}

	public static class Cell {
		Cell left;
		Cell right;
		Cell up;
		Cell down;
		int value;

		public Cell(int _value) {
			value = _value;
		}

		public String toString() {
			if (right != null) {
				if (value != -1) {
					return value + " " + right;
				}
				return right.toString();
			} else {
				if (value != -1) {
					return value + "";
				}
				return "";
			}
		}
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