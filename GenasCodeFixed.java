import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
//http://codeforces.com/contest/614/problem/B
//fixed post-test failure
public class GenasCodeFixed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String[] stuff = new String[n];
		int zeroCounter = 0;
		for (int a = 0; a < n; a++) {
			stuff[a] = input.next();
		}
		BigInteger result = new BigInteger("1");
		String specialCase3 = "";
		for (int a = 0; a < n; a++) {
			int numberOfZeros = getZeros(stuff[a]);
			zeroCounter += numberOfZeros;
			stuff[a] = stuff[a].substring(0, stuff[a].length() - numberOfZeros);
			if(stuff[a].length() > 10){
				specialCase3 = stuff[a];
			}
			else{
				result = result.multiply(new BigInteger(stuff[a]));
			}
			
		}
		if(specialCase3.equals("")){
			System.out.print(result);
		}
		else{
			System.out.print(specialCase3);
		}
		StringBuilder output = new StringBuilder();
		if (!result.equals(BigInteger.ZERO)) {
			for (int a = 0; a < zeroCounter; a++) {
				output.append('0');
			}
		}
		System.out.println(output);
	}

	private static int getZeros(String string) {
		int count = 0;
		if (string.equals("0")) {
			return 0;
		}
		for (int a = string.length() - 1; a >= 0; a--) {
			if (string.charAt(a) == '0') {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

}
