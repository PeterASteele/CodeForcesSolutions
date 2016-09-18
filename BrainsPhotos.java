import java.util.Scanner;
//http://codeforces.com/problemset/problem/707/A
public class BrainsPhotos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		for (int a = 0; a < n * m; a++) {
			String tmp = input.next();
			if (tmp.equals("C") || tmp.equals("M")
					|| tmp.equals("Y")) {
				System.out.println("#Color");
				return;
			}
		}
		System.out.println("#Black&White");
		return;
	}

}