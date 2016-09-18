import java.util.Scanner;

//http://codeforces.com/problemset/problem/706/A
public class BeruTaxi {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		int n = input.nextInt();
		double minTime = Double.MAX_VALUE;
		for(int a = 0; a < n; a++){
			int xTemp = input.nextInt()-x;
			int yTemp = input.nextInt()-y;
			double speed = input.nextInt();
			double hypot = Math.hypot(xTemp, yTemp);
			double time = hypot/speed;
			if(time < minTime){
				minTime = time;
			}
		}
		System.out.println(minTime);
	}
}