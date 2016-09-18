import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/707/D
public class PersistantBookcase {
	static int[] answers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();
		int q = input.nextInt();
		answers = new int[q + 1];
		boolean[][] grid = new boolean[n][m];
		boolean[] flipped = new boolean[n];
		int[] bookCount = new int[n];
		int bookTotal = 0;

		List<Integer>[] next = new ArrayList[q+1];
		for (int a = 0; a <= q; a++) {
			next[a] = new ArrayList<Integer>();
		}

		ArrayList<Integer>[] val = new ArrayList[q+1];
		for (int a = 0; a <= q; a++) {
			val[a] = new ArrayList<Integer>();
		}

		for (int b = 1; b <= q; b++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			int type = input.nextInt();
			tmp.add(type);
			if (type <= 2) {
				tmp.add(input.nextInt() - 1);
				tmp.add(input.nextInt() - 1);
			} else {
				if (type == 4) {
					tmp.add(input.nextInt());
					next[tmp.get(1)].add(b);
				} else {
					tmp.add(input.nextInt() - 1);
				}
			}
			val[b] = tmp;
		}
		for (int b = 0; b <= q-1; b++) {
			if (val[b + 1].get(0) != 4) {
				next[b].add(b + 1);
			}
		}
		evaluate(next, val, grid, flipped, bookCount, bookTotal, 0);
//		System.out.println(Arrays.toString(next));
		// System.out.println(Arrays.toString(answers));
		for (int a = 1; a <= q; a++) {
			System.out.println(answers[a]);
		}
	}

	private static void evaluate(List<Integer>[] next,
			ArrayList<Integer>[] val, boolean[][] grid, boolean[] flipped,
			int[] bookCount, int bookTotal, int q) {
//		System.out.println(q + "\t" + Arrays.deepToString(grid) + "\n\t"
//				+ Arrays.toString(flipped) + "\n\t" + " "
//				+ Arrays.toString(bookCount) + "\n\t" + bookTotal);
		boolean changed = false;
		if (q != 0) {
			if (val[q].get(0) == 1) {
				int x = val[q].get(1);
				int y = val[q].get(2);
				if (!(grid[x][y] ^ flipped[x])) {
					changed = true;
					grid[x][y] = flipped[x] ^ true;
					bookCount[x]++;
					bookTotal++;
				}
				answers[q] = bookTotal;
			}
			if (val[q].get(0) == 2) {
				int x = val[q].get(1);
				int y = val[q].get(2);
				if ((grid[x][y] ^ flipped[x])) {
					changed = true;
					grid[x][y] = flipped[x] ^ false;
					bookCount[x]--;
					bookTotal--;
				}
				answers[q] = bookTotal;
			}
			if (val[q].get(0) == 3) {
				int x = val[q].get(1);
				flipped[x] = !flipped[x];
				bookTotal -= bookCount[x];
				bookCount[x] = grid[x].length - bookCount[x];
				bookTotal += bookCount[x];
				answers[q] = bookTotal;
			}
			if (val[q].get(0) == 4) {
				answers[q] = answers[val[q].get(1)];
			}
		}
		
		for (Integer i : next[q]) {
			evaluate(next, val, grid, flipped, bookCount, bookTotal, i);
		}

		if (q != 0) {
			if (val[q].get(0) == 1) {
				int x = val[q].get(1);
				int y = val[q].get(2);
				if (changed) {
					grid[x][y] = !grid[x][y];
					bookCount[x]--;
					bookTotal--;
				}
			}
			if (val[q].get(0) == 2) {
				int x = val[q].get(1);
				int y = val[q].get(2);
				if (changed) {
					grid[x][y] = !grid[x][y];
					bookCount[x]++;
					bookTotal++;
				}
			}
			if (val[q].get(0) == 3) {
				int x = val[q].get(1);
				flipped[x] = !flipped[x];
				bookTotal -= bookCount[x];
				bookCount[x] = grid[x].length - bookCount[x];
				bookTotal += bookCount[x];
			}
		}
	}
}