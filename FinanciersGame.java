import java.util.Scanner;
//http://codeforces.com/contest/738/problem/F
public class FinanciersGame {
	static int[] finances;
	static int[] prefixSumFinances;
	static int[][][][] resultsArray = new int[2][2200][180][90];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		finances = new int[n];
		prefixSumFinances = new int[n + 1];
		for (int a = 0; a < n; a++) {
			finances[a] = input.nextInt();
			prefixSumFinances[a + 1] = prefixSumFinances[a] + finances[a];
		}
		for(int a =0 ; a < 2; a++){
			for(int b = 0; b < 2200; b++){
				for(int c = 0; c < 180; c++){
					for(int d = 0; d < 90; d++){
						resultsArray[a][b][c][d] = Integer.MIN_VALUE;
					}
				}
			}
		}
		System.out.println(solve(0, finances.length - 1, true, 1));
//		System.out.println(results.size());
//		long biggestDiff = 0;
//		long biggestGame = 0;
//		for(HashObj i: results.keySet()){
//			if(Math.abs(4000-i.right - i.left) > biggestDiff){
//				biggestDiff = Math.abs(4000-i.right-i.left);
//			}
//			if(i.prevTurn > biggestGame){
//				biggestGame = i.prevTurn;
//			}
//		}
//		System.out.println("BiggestDifference is: "+ biggestDiff);
//		System.out.println("BiggestMove is: " + biggestGame);
	}

	private static int query(int left, int right) {
		return prefixSumFinances[right + 1] - prefixSumFinances[left];
	}

	private static int solve(int left, int right, boolean turn, int prevTurn) {
//		System.out.println(hashObj.prevTurn);
		// dynamic programming
		if(resultsArray[turn?1:0][left][n-right-left+90][prevTurn] != Integer.MIN_VALUE){
			return resultsArray[turn?1:0][left][n-right-left+90][prevTurn];
		}
		if (right + 1 == left) {
			return 0;
		}
		if (turn == true) {
			// go from the left
			int poss1Temp = Math.min(right + 1, left
					+ prevTurn);
			int poss2Temp = Math.min(right + 1, left
					+ prevTurn + 1);
			int possibility1 = Integer.MIN_VALUE/2;
			if (poss1Temp == left + prevTurn) {
				possibility1 = (-1 * solve(poss1Temp,
						right, false, prevTurn))
						+ query(left, poss1Temp - 1);
			}
			int possibility2 = Integer.MIN_VALUE/2;
			if (poss2Temp == left + prevTurn + 1) {
				possibility2 = (-1 * solve(poss2Temp,
						right, false, prevTurn+1))
						+ query(left, poss2Temp - 1);
			}
			int tmp = Math.max(possibility1, possibility2);
			if(tmp == Integer.MIN_VALUE/2){
				tmp = 0;
			}
			resultsArray[turn?1:0][left][n-right-left+90][prevTurn] = tmp;
			return tmp;
		} else {
			// go from the right
			int poss1Temp = Math.max(left - 1, right
					- prevTurn);
			int poss2Temp = Math.max(left - 1, right
					- prevTurn - 1);
			int possibility1 = Integer.MIN_VALUE/2;
			if (poss1Temp == right - prevTurn) {
				possibility1 = (-1 * solve(left, poss1Temp,
						true, prevTurn))
						+ query(poss1Temp + 1, right);
			}
			int possibility2 = Integer.MIN_VALUE/2;
			if (poss2Temp == right - prevTurn - 1) {
				possibility2 = (-1 * solve(left, poss2Temp,
						true, prevTurn + 1))
						+ query(poss2Temp + 1, right);
			}
			int tmp = Math.max(possibility1, possibility2);
			if(tmp == Integer.MIN_VALUE/2){
				tmp = 0;
			}
			resultsArray[turn?1:0][left][n-right-left+90][prevTurn] = tmp;
			return tmp;
		}
		// TODO Auto-generated method stub

	}

	public static class HashObj {
		int left;
		int right;
		boolean turn;
		int prevTurn;

		public HashObj(int _left, int _right, boolean _turn, int _prevTurn) {
			left = _left;
			right = _right;
			turn = _turn;
			prevTurn = _prevTurn;
		}

		@Override
		public int hashCode() {
			return left * 101 + right + (turn ? 1 : 0 * 100237) + prevTurn
					* 213947;
		}

		@Override
		public boolean equals(Object o) {
			HashObj o2 = (HashObj) o;
			return left == o2.left && right == o2.right && turn == o2.turn
					&& prevTurn == o2.prevTurn;
		}

		@Override
		public String toString() {
			return "(" + left + ", " + right + ") " + turn + " " + prevTurn;
		}
	}
}
