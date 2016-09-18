import java.util.Scanner;

//http://codeforces.com/problemset/problem/711/A
public class BusToUdayland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		boolean OK = false;
		StringBuilder output = new StringBuilder();
		for(int a = 0; a < n; a++){
			String tmp = input.next();
			if((!OK) && tmp.charAt(0) == tmp.charAt(1) && tmp.charAt(0) == 'O'){
				OK = true;
				output.append("++");
			}
			else{
				output.append(tmp.charAt(0) +""+ tmp.charAt(1));
			}
			output.append("|");
			if((!OK) && tmp.charAt(3) == tmp.charAt(4) && tmp.charAt(3) == 'O'){
				OK = true;
				output.append("++");
			}
			else{
				output.append(tmp.charAt(3) +""+ tmp.charAt(4));
			}
			output.append("\n");
		}
		if(OK){
			System.out.println("YES");
			System.out.print(output);
		}
		else{
			System.out.println("NO");
		}
	}

}