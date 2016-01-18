import java.util.HashSet;
import java.util.Scanner;


public class Bulbs {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numberOfButtons = input.nextInt();
		int numberOfBulbs = input.nextInt();
		HashSet<Integer> lit = new HashSet<Integer>();
		for(int a = 0; a < numberOfButtons; a++){
			int x = input.nextInt();
			for(int b = 0; b < x; b++){
				lit.add(input.nextInt());
			}
		}
		if(lit.size() == numberOfBulbs){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}	

}
