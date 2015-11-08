import java.util.Scanner;
//http://codeforces.com/contest/595/problem/A

public class VitalyAndNight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int floors = input.nextInt();
		int flatsPerFloor = input.nextInt();
		int count = 0;
		for(int a = 0; a < floors*flatsPerFloor; a++){
			int temp = input.nextInt();
			int temp2 = input.nextInt();
			if(temp == 1 || temp2 == 1){
				count++;
			}
		}
		System.out.println(count);
	}

}
