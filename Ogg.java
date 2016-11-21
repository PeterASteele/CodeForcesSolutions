import java.util.Scanner;

//http://codeforces.com/contest/738/problem/A
public class Ogg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String in = input.next();
		
		String start = "o";
		while(start.length() < n){
			start += "go";
		}
		while(start.length() >= 3){
			in = in.replace(start, "***");
			start = start.substring(0, start.length()-2);
		}
		System.out.println(in);
	}

}
