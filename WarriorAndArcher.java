import java.util.Arrays;
import java.util.Scanner;


public class WarriorAndArcher {
//http://codeforces.com/contest/595/problem/D
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int startingPositions = input.nextInt();
		int[] starting = new int[startingPositions];
		for(int a = 0; a < startingPositions; a++){
			starting[a] = input.nextInt();
		}
		Arrays.sort(starting);
		int bans = (startingPositions-2)/2;
		double change = Math.pow(2, 31);
		double delta = change/2.0; //no more 1.9 rip
		while(true){
			int total = 0;
			int nonban = starting[0];
			int index = 1;
			
			while(total <= bans){
				if(starting[index] - nonban >= change){
					nonban = starting[index];
				}
				else{
					total++;
				}
				index++;
				if(index >= starting.length){
					break;
				}
			}
			if(total <= bans){
				change += delta;
				delta /= 2.0;
			}
			else{
				change -= delta;
				delta /= 2.0;
			}
			if(delta < 2 * Math.ulp(delta)){
				break;
			}
		}
		System.out.println((int) (change));
	}

}
