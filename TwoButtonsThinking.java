import java.util.Scanner;
//http://codeforces.com/problemset/problem/520/B
public class TwoButtonsThinking {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		int count = 0;
		
		while (m > n) {
			m = m / (2 - m%2) + (m%2);
			count++;
		}
		
		System.out.println(count + n - m);
	}
}