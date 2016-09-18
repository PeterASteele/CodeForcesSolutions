import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/707/B
public class Bakery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> end = new ArrayList<Integer>();
		ArrayList<Long> costs = new ArrayList<Long>();
		
		for (int a = 0; a < m; a++) {
			int b = input.nextInt();
			int r = input.nextInt();
			long s = input.nextInt();
			start.add(b);
			end.add(r);
			costs.add(s);
		}
//		System.out.println(distances);
		boolean[] arr = new boolean[n+1];
		Arrays.fill(arr, false);
		for (int a = 0; a < k; a++) {
			arr[input.nextInt()] = true;
		}
		long bestDistance = Long.MAX_VALUE;
		for (int a = 0; a < m; a++){
			int startNum = start.get(a);
			int endNum = end.get(a);
			if(arr[startNum] ^ arr[endNum]){
				long dist = costs.get(a);
				if(dist < bestDistance){ 
//					System.err.println(startNum + " " + endNum + " " + dist);
					bestDistance = dist;
				}
			}
		}
		if(bestDistance == Long.MAX_VALUE){
			bestDistance = -1;
		}
		System.out.println(bestDistance);
	}

}