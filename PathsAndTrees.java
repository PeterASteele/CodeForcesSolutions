import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;
//Solved with Daniel (intrepidcoder)
public class PathsAndTrees {
	static ArrayList<Edge>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner input = new FastScanner();
		int n = input.nextInt();
		int e = input.nextInt();
		adjacencyList = new ArrayList[n];
		for (int a = 0; a < n; a++) {
			adjacencyList[a] = new ArrayList<Edge>();
		}
		for (int a = 0; a < e; a++) {
			int start = input.nextInt() - 1;
			int end = input.nextInt() - 1;
			int length = input.nextInt();
			adjacencyList[start].add(new Edge(end, length, a));
			adjacencyList[end].add(new Edge(start, length, a));
		}
		int start = input.nextInt() - 1;
		Edge[] answer = dijkstra(n, start);
		long total = 0;
		for (int a = 0; a < answer.length; a++) {
			if (a != start) {
				total += answer[a].length;
			}
		}
		System.out.println(total);

		StringBuilder output = new StringBuilder();
		for (int a = 0; a < answer.length; a++) {
			if (a != start) {
				output.append((answer[a].id + 1) + " ");
			}
		}
		System.out.println(output);
	}

	static class Edge {
		int destination;
		int length;
		int id;
		boolean used;

		public Edge(int d, int l, int _id) {
			destination = d;
			length = l;
			id = _id;
			used = false;
		}

		public String toString() {
			return destination + " " + length + " " + id;
		}
	}

	// DIJKSTRA2016
	static final long INF = Long.MAX_VALUE;

	/*
	 * Graph contains vertices 0...N-1 'start' and 'goal' are in [0, N-1]
	 */
	static Edge[] dijkstra(int N, int start) {
		final long[] dist = new long[N];
		final long[] length = new long[N];
		Arrays.fill(dist, INF);
		Arrays.fill(length, INF); // length is the distance to the previous edge
									// in the tree.
		dist[start] = 0;
		length[start] = 0;
		int count = 0;

		Edge[] prev = new Edge[N];
		TreeSet<TempObj> frontier = new TreeSet<TempObj>(new Comparator<TempObj>() {
			public int compare(TempObj v1, TempObj v2) {
				if (v1.dist == v2.dist) {
					if(v1.length == v2.length){
						return v1.id-v2.id;
					}
					return (int) (v1.length - v2.length);
				}
				return (int) (v1.dist - v2.dist);
			}
		});

		frontier.add(new TempObj(start, 0, 0, new Edge(-1, -1, -1)));
		boolean[] optimal = new boolean[N];

		while (!frontier.isEmpty()) {
//			System.out.println(frontier);
			TempObj u2 = frontier.pollFirst();
			
			int u = u2.id;
			if (count == N) {
				break;
			}

			if (optimal[u]) {
				continue;
			} else {
				prev[u] = u2.e;
				dist[u] = u2.dist;
				length[u] = u2.length;
				count++;
			}
			optimal[u] = true;

			for (Edge v2 : neighborsOf(u)) {
				int v = v2.destination;
				long uv = v2.length;
				frontier.add(new TempObj(v, dist[u] + uv, uv, v2));
			}
		}
		// now 'prev' contains the shortest path tree, which includes 'goal'
		// 'dist' contains the shortest distance from start to all nodes
		return prev;
	}

	static private ArrayList<Edge> neighborsOf(int u) {
		return adjacencyList[u];
	}

	public static class TempObj {
		Edge e;
		int id;
		long dist;
		long length;

		public TempObj(int _id, long _dist, long _length, Edge e2) {
			e = e2;
			id = _id;
			dist = _dist;
			length = _length;
		}
		public boolean equals(Object o){
			TempObj temp = (TempObj) o;
			return temp.id == id && dist == temp.dist && length == temp.length;
		}
		public String toString(){
			return "(" + e + " " + id + " " + dist + " " + length + ")";
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