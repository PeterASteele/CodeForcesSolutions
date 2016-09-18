import java.util.Scanner;
//http://codeforces.com/problemset/problem/715/A
public class PlusAndSquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long n = input.nextInt();
		System.out.println(2);
		int startLevel = 2;
		for(long q = startLevel; q <= n; q++){
			System.out.println((q*(q+1)*(q+1)-(q-1)));
		}
	}

}