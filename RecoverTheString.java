import java.util.Scanner;
//http://codeforces.com/problemset/problem/708/B
public class RecoverTheString {
	static boolean DEBUG = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long zz = input.nextInt();
		long zo = input.nextInt();
		long oz = input.nextInt();
		long oo = input.nextInt();
		
		//n*(n+1)/2 == a
		boolean OK = true;
		long numberOfZero = -1;
		long numberOfOne = -1;
		for(long a = 0; a <= 100000; a++){
			if(a * (a-1) / 2 == zz){
				numberOfZero = a;
			}
			if(a * (a-1) / 2 == oo){
				numberOfOne = a;
			}
		}
		if(numberOfZero == -1){
			OK = false;
		}
		if(numberOfOne == -1){
			OK = false;
		}
		if(oz == 0 && zz == 0 && zo == 0){
			numberOfZero = 0;
		}
		if(oz == 0 && zo == 0 && oo == 0){
			numberOfOne = 0;
		}
		if(oz == 0 && zo == 0 && oo == 0 && zz == 0){
			System.out.println("1");
			System.exit(0);
		}
		if(DEBUG){
			System.out.println(numberOfOne + " " + numberOfZero);
		}
		if(!OK){
			exit();
		}
		if(zo + oz != numberOfZero * numberOfOne){
			exit();
		}
		else{
			long currentOz = numberOfZero * numberOfOne;
			
			StringBuilder output = new StringBuilder();
			int oneCount = 0;
			for(long a = numberOfZero; a > 0; a--){
				if(currentOz >= zo + a){
					output.append('1');
					currentOz -= a;
					a++;
					oneCount++;
				}
				else{
					output.append('0');
				}
			}
			for(int a = 0; a < numberOfOne-oneCount; a++){
				output.append('1');
			}
			System.out.println(output);
		}	
	}

	private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("Impossible");
		System.exit(0);
	}

}