import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
//http://codeforces.com/problemset/problem/708/C
public class Centroids {
	static int n;
	static TreeMap<Integer, Integer> freqDist;
	static int[] answers;

	public static void main(String[] args) {
		freqDist = new TreeMap<Integer, Integer>();
		// TODO Auto-generated method stub
		FastScanner input = new FastScanner();
		n = input.nextInt();
		answers = new int[n];
		Arrays.fill(answers, -1);
		Tree[] arr = new Tree[n];
		for (int a = 0; a < n; a++) {
			arr[a] = new Tree(a);
		}
		for (int a = 0; a < n - 1; a++) {
			int node1 = input.nextInt() - 1;
			int node2 = input.nextInt() - 1;
			arr[node1].connect.add(arr[node2]);
			arr[node2].connect.add(arr[node1]);
		}
		arr[0].populateCount();
		int centroidId = arr[0].findCentroid();
		arr[centroidId].populateCount(); // reroot
		arr[centroidId].fillTreeMap();
		// System.out.println(freqDist);
		answers[centroidId] = 1;
		int total = arr[centroidId].countUnderneath;
		arr[centroidId].onStack = true;

		
		for (Tree i : arr[centroidId].connect) {

			i.unfillTreeMap();
			total = total - i.countUnderneath;
			Integer val = freqDist.get(total);
			if (val == null) {
				freqDist.put(total, 1);
			} else {
				freqDist.put(total, val + 1);
			}
			i.traverse();
			int num = freqDist.get(total);
			if (num == 1) {
				freqDist.remove(total);
			} else {
				freqDist.put(total, num - 1);
			}
			total = total + i.countUnderneath;
			i.fillTreeMap();

		}
		StringBuilder out = new StringBuilder();
		for (int a = 0; a < n; a++) {
			out.append(answers[a] + " ");
		}
		System.out.println(out);
	}

	public static class Tree {
		ArrayList<Tree> connect;
		int countUnderneath;
		boolean onStack = false;
		int id;

		public Tree(int _id) {
			id = _id;
			countUnderneath = 0;
			connect = new ArrayList<Tree>();
			onStack = false;
		}

		public void traverse() {

			int needAtLeast = n - (n / 2) - countUnderneath;
			// System.out.println(id + ": " + "Need at least: " + needAtLeast +
			// " have: " + freqDist.ceilingKey(needAtLeast));
			// System.out.println(freqDist);
			if (freqDist.ceilingKey(needAtLeast) != null && freqDist.ceilingKey(needAtLeast) <= n / 2) {
				answers[id] = 1;
			} else {
				answers[id] = 0;
			}

			for (Tree i : connect) {
				onStack = true;
				if (!i.onStack) {
					i.traverse();
				}
				onStack = false;
			}

		}

		public void unfillTreeMap() {
			// System.out.println(freqDist + " " + this.toString());
			if (countUnderneath != n) {
				int num = freqDist.get(countUnderneath);
				if (num == 1) {
					freqDist.remove(countUnderneath);
				} else {
					freqDist.put(countUnderneath, num - 1);
				}
			}
			for (Tree i : connect) {
				onStack = true;
				if (!i.onStack)
					i.unfillTreeMap();
				onStack = false;
			}
		}

		public void fillTreeMap() {
			if (countUnderneath != n) {
				Integer val = freqDist.get(countUnderneath);
				if (val == null) {
					freqDist.put(countUnderneath, 1);
				} else {
					freqDist.put(countUnderneath, val + 1);
				}
			}
			for (Tree i : connect) {
				onStack = true;
				if (!i.onStack)
					i.fillTreeMap();
				onStack = false;
			}

		}

		public int findCentroid() {
			if (countUnderneath >= n / 2) {
				// check if the centroid is there
				int max = -1;
				for (Tree i : connect) {
					if (i.onStack == false) {
						if (max < i.countUnderneath) {
							max = i.countUnderneath;
						}
					}
				}
				if (max <= n / 2 && countUnderneath >= n / 2) {
					return id;
				}

				for (Tree i : connect) {
					onStack = true;
					if (i.onStack == false) {
						int tmp = i.findCentroid();
						if (tmp != -1) {
							onStack = false;
							return tmp;
						}
					}
					onStack = false;
				}
			}
			return -1;
		}

		public int populateCount() {

			int total = 1;
			for (Tree i : connect) {
				onStack = true;
				if (!i.onStack) {
					total += i.populateCount();
				}
				onStack = false;
			}
			countUnderneath = total;
			return total;
		}

		public String toString() {
			return (id + ": " + countUnderneath);

		}
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