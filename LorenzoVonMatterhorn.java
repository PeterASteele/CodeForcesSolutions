import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/696/A
public class LorenzoVonMatterhorn {
	static HashMap<Edge, Long> map;
	static boolean DEBUG = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		map = new HashMap<Edge, Long>();
		int query = input.nextInt();
		for (int a = 0; a < query; a++) {
			int first = input.nextInt();
			if (first == 1) {
				// new rule
				long start = input.nextLong();
				long end = input.nextLong();
				long cost = input.nextLong();
				ArrayList<Long> path = path(start, end);
				for (int b = 0; b < path.size() - 1; b++) {
					Edge tmp = new Edge(path.get(b), path.get(b + 1));
					if (map.containsKey(tmp)) {
						map.put(tmp, map.get(tmp) + cost);
					} else {
						map.put(tmp, cost);
					}
				}
				if (DEBUG) {
					System.out.println("DEBUG FOR QUERY TYPE ADD");
					System.out.println(path);
					System.out.println(map + " " + start + " " + end + " "
							+ cost);
				}
			} else {
				// calculate cost
				long start = input.nextLong();
				long end = input.nextLong();
				ArrayList<Long> path = path(start, end);
				long cost = 0;
				for (int b = 0; b < path.size() - 1; b++) {
					Edge tmp = new Edge(path.get(b), path.get(b + 1));
					if (map.containsKey(tmp)) {
						cost += map.get(tmp);
					}
				}
				if (DEBUG) {
					System.out.println(path + " " + start + " " + end);
				}
				System.out.println(cost);
			}
		}
	}

	public static ArrayList<Long> path(long start, long end) {
		ArrayList<Long> path = new ArrayList<Long>();
		ArrayList<Long> path2 = new ArrayList<Long>();
		long startTemp = start;
		long endTemp = end;
		while (startTemp != 0) {
			path.add(startTemp);
			startTemp /= 2;
		}
		while (endTemp != 0) {
			path2.add(endTemp);
			endTemp /= 2;
		}
		long tmp = -1;
		while (true) {
			if (path.size() == 0 || path2.size() == 0) {
				break;
			}
			if (path.get(path.size() - 1).equals(path2.get(path2.size() - 1)) == false) {
				break;
			}
			tmp = path.get(path.size() - 1);
			path.remove(path.size() - 1);
			path2.remove(path2.size() - 1);
			
		}
		path.add(tmp);
		for (int a = path2.size() - 1; a >= 0; a--) {
			path.add(path2.get(a));
		}
		return path;
	}

	public static class Edge implements Comparable<Edge> {
		long start;
		long end;

		public Edge(long _start, long _end) {
			start = Math.min(_start, _end);
			end = Math.max(_start, _end);
		}
		@Override
		public int hashCode() {
			return (int) (start * 37 + end + start / 5000001);
		}

		@Override
		public boolean equals(Object o) {
			Edge e = (Edge) o;
			return start == e.start && end == e.end;
		}

		@Override
		public int compareTo(Edge arg0) {
			return (start == arg0.start) ? (int) (end - arg0.end)
					: (int) (start - arg0.start);
		}

		public String toString() {
			return "(" + start + " " + end + ")";
		}
	}
}