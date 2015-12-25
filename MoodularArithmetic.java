import java.util.Scanner;


public class MoodularArithmetic {
//http://codeforces.com/contest/604/problem/D
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int p = input.nextInt();
		int k = input.nextInt();
		if (k == 0){
			System.out.println(computePow(p, p-1));
			System.exit(0);
		}
		if (k == 1){
			System.out.println(computePow(p, p));
			System.exit(0);
		}
		boolean[] hit = new boolean[p];
		hit[0] = true;
		int degrees = 0;
		for(int a = 1; a < p; a++){
			if(hit[a] == false){
				degrees++;
				long temp = a;
				while(hit[(int) temp] == false){
					hit[(int) temp] = true;
					temp = (((long) k) * temp) % ((long) p);
				}
			}
		}
		System.out.println(computePow(p, degrees)); 
	}

	private static long computePow(int p, int p2) {
		long temp = 1;
		for(int a = 0; a < p2; a++){ //inefficient, convert to log(n) power calculation if necessary.
			temp = temp * ((long) p);
			temp = temp % ((long) 1000000007);
		}
		return temp;
	}
}
