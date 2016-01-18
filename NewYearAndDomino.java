import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
//http://codeforces.com/contest/611/problem/C
public class NewYearAndDomino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		int width = input.nextInt();
		String[] hold = new String[height + 2];
		hold[0] = generateForbidString(width + 2);
		hold[height + 1] = generateForbidString(width + 2);
		input.nextLine();
		for (int a = 1; a < hold.length - 1; a++) {
			hold[a] = "#" + input.nextLine() + "#";
		}
		boolean[][] horizontal = new boolean[height+2][width+2];
		boolean[][] vertical = new boolean[height+2][width+2];
		for (int a = 1; a < hold.length; a++) {
			for (int b = 1; b <= width; b++) {
				if (isValid(a, b, a+1, b, hold)) {
					vertical[a][b] = true;
				}
				if (isValid(a, b, a, b+1, hold)) {
					horizontal[a][b] = true;
				}
			}
		}
		//We have the possibities sorted by vertical and horizontal; time to do DP (each number means the upper right corner);
		int[][] verticalDP = new int[height+2][width+2];
		for (int a = 1; a <= height; a++) {
			for (int b = 1; b <= width; b++) {
				verticalDP[a][b] = verticalDP[a-1][b] + (verticalDP[a][b-1]-verticalDP[a-1][b-1]) + ((vertical[a-1][b])?1:0);
			}
		}
		int[][] horizontalDP = new int[height+2][width+2];
		for (int a = 1; a <= height; a++) {
			for (int b = 1; b <= width; b++) {
				horizontalDP[a][b] = horizontalDP[a][b-1] + (horizontalDP[a-1][b]-horizontalDP[a-1][b-1]) + ((horizontal[a][b-1])?1:0);
			}
		}
		/*
		for (int a = 0; a <= height; a++) {
			for (int b = 0; b <= width; b++) {
				System.out.print("(" + horizontalDP[a][b] + ", " + verticalDP[a][b] + ")\t");
			}
			System.out.println();
		}
		*/
		
		
		int queries = input.nextInt();
		input.nextLine();
		int sum = 0;
		for(int a = 0; a < queries; a++){
			int upperLeftX = input.nextInt();
			int upperLeftY = input.nextInt();
			int lowerRightX = input.nextInt();
			int lowerRightY = input.nextInt();
			int horizontalTotal = horizontalDP[lowerRightX][lowerRightY] - horizontalDP[lowerRightX][upperLeftY] - horizontalDP[upperLeftX-1][lowerRightY] + horizontalDP[upperLeftX-1][upperLeftY];
			int verticalTotal = verticalDP[lowerRightX][lowerRightY] - verticalDP[upperLeftX][lowerRightY] - verticalDP[lowerRightX][upperLeftY-1] + verticalDP[upperLeftX][upperLeftY-1];
			System.out.println(horizontalTotal + verticalTotal);
		}		
	}
	private static class Domino{
		int startX;
		int startY;
		int endX;
		int endY;
		public Domino(int startX, int startY, int endX, int endY){
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}
	}
	private static boolean isValid(int a, int b, int i, int b2, String[] hold) {
		if(hold[a].charAt(b) == '.' && hold[i].charAt(b2) == '.'){
			return true;
		}
		return false;
	}

	private static String generateForbidString(int i) {
		StringBuilder output = new StringBuilder();
		for (int a = 0; a < i; a++) {
			output.append("#");
		}
		return output.toString();
	}
}
