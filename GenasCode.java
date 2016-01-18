import java.util.ArrayList;
import java.util.Scanner;

//http://codeforces.com/contest/614/problem/B
//failed post test. Oops.
public class GenasCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		int pow = 0;
		int count = 0;
		for(int a = 0; a < n; a++){
			String temp = input.next();
			if(isBeautiful(temp)){
				pow += temp.length()-1;
			}
			else{
				count++;
				System.out.print(temp);
				if(temp.equals("0")){
					System.exit(0);
				}
			}
		}
		StringBuilder output = new StringBuilder();
		if(count == 0){
			output.append('1');
		}
		for(int a = 0; a < pow; a++){
			output.append('0');
		}
		System.out.println(output);
	}

	private static boolean isBeautiful(String temp) {
		if(temp.length() < 1){
			return false;
		}
		if(temp.charAt(0) != '1'){
			return false;
		}
		for(int a = 1; a < temp.length(); a++){
			if(temp.charAt(a) != '0'){
				return false;
			}
		}
		return true;
	}

}
