import java.util.HashMap;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/713/A
public class SonyaAndQueries {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] specFreqDist = new int[2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2];
		for(int a = 0; a < n; a++){
			String OP = input.next();
			if(OP.equals("+")){
				specFreqDist[transform(input.nextLong())]++;
			}
			if(OP.equals("-")){
				specFreqDist[transform(input.nextLong())]--;
			}
			if(OP.equals("?")){
				System.out.println(specFreqDist[transform(input.nextLong())]);
			}
		}
	}

	private static int transform(long nextInt) {
		int output = 0;
		for(int a = 0; a < 18; a++){
			output *= 2;
			output += nextInt%2;
			nextInt = nextInt/10;
		}
		return output;
	}
}