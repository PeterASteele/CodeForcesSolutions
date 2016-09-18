import java.util.ArrayList;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/696/B
public class Puzzles {
	static ArrayList<Integer>[] edges;
	static Node[] nodeLookup;
	static boolean DEBUG = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		edges = new ArrayList[n];
		nodeLookup = new Node[n];
		
		for (int a = 0; a < n; a++) {
			Node tmp = new Node(a);
			nodeLookup[a] = tmp;
			edges[a] = new ArrayList<Integer>();
		}

		for (int a = 1; a < n; a++) {
			int parent = input.nextInt()-1;
			edges[parent].add(a);
		}
		
		if (DEBUG) {
			for (int a = 0; a < n; a++) {
				System.out.print(nodeLookup[a] + " ");
			}
			System.out.println();
		}
		
		calculateDepth(0);
		
		if (DEBUG) {
			for (int a = 0; a < n; a++) {
				System.out.print(nodeLookup[a] + " ");
			}
			System.out.println();
		}
		
		calculateScore(0, 0);
		
		if (DEBUG) {
			for (int a = 0; a < n; a++) {
				System.out.print(nodeLookup[a] + " ");
			}
			System.out.println();
		}
		
		for (int a = 0; a < n; a++) {
			System.out.print(nodeLookup[a].answer + " ");
		}
	}

	private static void calculateScore(int i, double j) {
		nodeLookup[i].answer = j + 1;
		double total = j + 1 + (nodeLookup[i].info / 2.0);
		for (int node : edges[i]) {
			calculateScore(node, total - ((nodeLookup[node].info+1) / 2.0));
		}
	}

	private static int calculateDepth(int i) {
		int sum = 1;
		for (int j : edges[i]) {
			sum += calculateDepth(j);
		}
		nodeLookup[i].info = sum-1;
		return sum;
	}

	public static class Node {
		long id;
		long info;
		double answer;

		public Node(long _id) {
			id = _id;
		}

		public String toString() {
			return "(" + id + ": " + info + " " + answer + ")";
		}
	}
}