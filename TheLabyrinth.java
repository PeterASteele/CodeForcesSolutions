import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

//http://codeforces.com/contest/616/problem/C
public class TheLabyrinth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		input.nextLine();
		String[] inputStrings = new String[n];
		for(int a = 0; a < n; a++){
			inputStrings[a] = input.nextLine();
		}
		int[][] inputGrid = new int[n][m];
		for(int a = 0; a < n; a++){
			for(int b = 0; b < m; b++){
				inputGrid[a][b] = (inputStrings[a].charAt(b) == '*')?-1:0;	
			}
		}
		int[] pointToFlood = new int[n * m];
		HashMap<Integer, Integer> floodSizeMap = new HashMap<Integer, Integer>();
		floodFill(inputGrid, pointToFlood, floodSizeMap);
		//flood is done.
		floodSizeMap.put(-1, 0);
		//System.out.println(floodSizeMap.toString());
		//prepare output
		for(int a = 0; a < n; a++){
			char[] output = new char[m];
			for(int b = 0; b < m; b++){
				if(inputGrid[a][b] != -1){
					output[b] = '.';
				}
				else{
					HashSet<Integer> floodIDList = new HashSet<Integer>();
					floodIDList.add((isInBounds(a-1, b, inputGrid) && inputGrid[a-1][b] == -2)?pointToFlood[(a-1)*inputGrid[0].length + b]:-1);
					//System.out.println(1);
					floodIDList.add((isInBounds(a+1, b, inputGrid) && inputGrid[a+1][b] == -2)?pointToFlood[(a+1)*inputGrid[0].length + b]:-1);
					//System.out.println(2);
					floodIDList.add((isInBounds(a, b-1, inputGrid) && inputGrid[a][b-1] == -2)?pointToFlood[(a)*inputGrid[0].length + b-1]:-1);
					//System.out.println(3);
					floodIDList.add((isInBounds(a, b+1, inputGrid) && inputGrid[a][b+1] == -2)?pointToFlood[(a)*inputGrid[0].length + b+1]:-1);
					int count = 0;
					for(Integer floodID:floodIDList){
						count += floodSizeMap.get(floodID);
					}
					output[b] = (char)(((count+1)%10) + '0');
				}
			}
			System.out.println(new String(output));
		}
		
	}
	private static void floodFill(int[][] inputGrid, int[] pointToFlood, HashMap<Integer, Integer> floodSizeMap){
		int n = inputGrid.length;
		int m = inputGrid[0].length;
		int floodID = -1;
		for(int a = 0; a < n; a++){
			for(int b = 0; b < m; b++){
				if(inputGrid[a][b] == 0){
					floodID++;
					int count = 0;
					ArrayDeque<Point> pointsToInvestigate = new ArrayDeque<Point>();
					pointsToInvestigate.add(new Point(a, b));
					while(!pointsToInvestigate.isEmpty()){
						Point c = pointsToInvestigate.pop();
						if(isInBounds(c.a, c.b, inputGrid) && inputGrid[c.a][c.b] == 0){
							count++;
							pointToFlood[c.a*inputGrid[0].length + c.b] = floodID;
							inputGrid[c.a][c.b] = -2;
							pointsToInvestigate.add(new Point(c.a+1, c.b));
							pointsToInvestigate.add(new Point(c.a, c.b+1));
							pointsToInvestigate.add(new Point(c.a-1, c.b));
							pointsToInvestigate.add(new Point(c.a, c.b-1));
						}
					}
					floodSizeMap.put(floodID, count);
				}
			}
		}
		
	}
//	private static int floodHelper(int a, int b, int[][] inputGrid, int[] pointToFlood, int floodID) {
//		int total = 0;
//		if(isInBounds(a-1, b, inputGrid) && inputGrid[a-1][b] == 0){
//			inputGrid[a-1][b] = -2;
//			pointToFlood[(a-1)*inputGrid[0].length + b] = floodID;
//			total += 1+floodHelper(a-1, b, inputGrid, pointToFlood, floodID);
//		}
//		if(isInBounds(a, b-1, inputGrid) && inputGrid[a][b-1] == 0){
//			inputGrid[a][b-1] = -2;
//			pointToFlood[(a)*inputGrid[0].length + b-1] = floodID;
//			total += 1+floodHelper(a, b-1, inputGrid, pointToFlood, floodID);
//		}
//		if(isInBounds(a+1, b, inputGrid) && inputGrid[a+1][b] == 0){
//			inputGrid[a+1][b] = -2;
//			pointToFlood[(a+1)*inputGrid[0].length + b] = floodID;
//			total += 1+floodHelper(a+1, b, inputGrid, pointToFlood, floodID);
//		}
//		if(isInBounds(a, b+1, inputGrid) && inputGrid[a][b+1] == 0){
//			inputGrid[a][b+1] = -2;
//			pointToFlood[(a)*inputGrid[0].length + b+1] = floodID;
//			total += 1+floodHelper(a, b+1, inputGrid, pointToFlood, floodID);
//		}
//		return total;
//	}
	private static boolean isInBounds(int i, int j, int[][] inputGrid) {
		return (i >= 0 && j >= 0 && inputGrid.length > i && inputGrid[0].length > j);
	}
	public static class Point{
		int a;
		int b;
		public Point(int a2, int b2){
			a = a2;
			b = b2;
		}
		public String toString(){
			return "(" + a + ", " + b + ") ";
		}
		public boolean equals(Point c){
			if(this.a == c.a && this.b == c.b){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
}
