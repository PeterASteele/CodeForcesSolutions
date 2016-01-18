import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

//http://codeforces.com/contest/616/problem/B
public class DinnerWithEmma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] cost = new int[n][m];
		for(int a = 0; a < n; a++)
			for(int b = 0; b < m; b++)
				cost[a][b] = input.nextInt();
		int max = -1;
		for(int a = 0; a < n; a++){
			int min = Integer.MAX_VALUE;
			for(int b = 0; b < m; b++){
				if(min > cost[a][b]){
					min = cost[a][b];
				}
			}
			if(max < min){
				max = min;
			}
		}
		System.out.println(max);
		
	}
	
}
