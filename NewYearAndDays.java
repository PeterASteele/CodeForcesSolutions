import java.util.Scanner;

//http://codeforces.com/contest/611/problem/A
public class NewYearAndDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String x = input.nextLine();
		
		Scanner input2 = new Scanner(x);
		int n = input2.nextInt();
		input2.next();
		String secondHalf = input2.next();
		if(secondHalf.equals("week")){
			if(n == 5 || n==6){
				System.out.println(53);
			}
			else{
				System.out.println(52);
			}
		}
		else{
			if(n <= 29){
				System.out.println(12);
			}
			else if(n <= 30){
				System.out.println(11);
			} else{
				System.out.println(7);
			}
			
		}
	}

}
