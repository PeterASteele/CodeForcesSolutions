import java.math.BigInteger;
import java.util.Scanner;

//http://codeforces.com/contest/614/problem/A
public class LinkCutTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		BigInteger start = new BigInteger(input.next());
		BigInteger end = new BigInteger(input.next());
		BigInteger k = new BigInteger(input.next());
		BigInteger move = BigInteger.ONE;
		int count = 0;
		for(int a = 0; a < 100; a++){
			if(move.compareTo(start) >= 0 && end.compareTo(move) >= 0){
				count++;
				System.out.print(move + " ");
			}
			move = move.multiply(k);
			if(move.compareTo(end) > 0){
				break;
			}
		}
		if(count == 0){
			System.out.println(-1);
		}
		else{
			System.out.println();
		}
	}

}
