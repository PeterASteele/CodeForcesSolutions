import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
//http://codeforces.com/contest/586/problem/D
public class PhillipandTrains {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.nextLine();
		int temp5 = 0;
		String line = input.nextLine();
		for(int a = 0; a < number; a++){
			
			Scanner tempS = new Scanner(line);
			temp5 = 0;
			int columns = tempS.nextInt();
			int trains = tempS.nextInt();
			ArrayList<String> temp = new ArrayList<String>();
			boolean[] trainsBool = new boolean[26];
			while(true){
				if(!input.hasNext()){
					break;
				}
				String temp2 = input.nextLine();
				Scanner tempScanner = new Scanner(temp2);
				try{
					tempScanner.nextInt();
					line = temp2;
					break;
				}
				catch(Exception e){
					
				}
				temp.add(temp2);
				for(int d = 0; d < temp2.length(); d++){
					if(temp2.charAt(d) != 's' && temp2.charAt(d) != '.'){
						trainsBool[temp2.charAt(d) - 'A'] = true;
					}
				}
				int sum = 0;
				for(int b = 0; b < 26; b++){
					if(trainsBool[b]){
						sum++;
					}
				}
				
				if(sum == trains){
					
					
				}
			}
			
			int[][] grid = new int[temp.size()][columns];
			for(int b = 0; b < temp.size(); b++){
				String temp2 = temp.get(b);
				for(int c = 0; c < temp2.length(); c++){
					if(temp2.charAt(c) == 's'){
						grid[b][c] = 1;
					}
					if(temp2.charAt(c) == '.'){
						grid[b][c] = -1;
					}
				}
			}
			for(int d = 0; d < temp.size(); d++){
				if(grid[d][1] == -1 && grid[d][0] == 1){
					grid[d][1] = 1;
				}
			}
			for(int b = 1; b < columns-1; b=b+3){
				int[] tempColumn = new int[temp.size()];
				for(int c = 0; c < temp.size(); c++){
					if(grid[c][b] == -1){
						if(c-1 >= 0){
							if(grid[c-1][b] == 1){
								tempColumn[c] = 1;
							}
						}
						if(c+1 < temp.size()){
							if(grid[c+1][b] == 1){
								tempColumn[c] = 1;
							}
						}
					}
				}
				for(int c = 0; c < temp.size(); c++){
					if(grid[c][b] == -1){
						grid[c][b] = tempColumn[c];
					}
				}
				for(int c = 0; c < temp.size(); c++){
					if(grid[c][b+1] == -1 && grid[c][b] == 1){
						grid[c][b+1] = grid[c][b];
					}
				}
				if(b+2 < columns){
					for(int c = 0; c < temp.size(); c++){
						if(grid[c][b+2] == -1 && grid[c][b+1] == 1){
							grid[c][b+2] = grid[c][b+1];
						}
					}
				}
				if(b+3 < columns){
					for(int c = 0; c < temp.size(); c++){
						if(grid[c][b+3] == -1 && grid[c][b+2] == 1){
							grid[c][b+3] = grid[c][b+2];
						}
					}
				}
			}
			boolean answer = false;
			for(int c = 0; c < temp.size(); c++){
				if(grid[c][columns-1] == 1){
					answer = true;
				}
			}
			
			if(answer){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		
	}

	// ////Fastscanner class.
	public static class Scanner2 {
		BufferedReader br;
		StringTokenizer st;

		public Scanner2(Reader in) {
			br = new BufferedReader(in);
		}

		public Scanner2() {
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
