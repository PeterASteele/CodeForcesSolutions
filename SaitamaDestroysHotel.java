import java.util.Scanner;
//http://codeforces.com/contest/608/problem/A

public class SaitamaDestroysHotel {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfPassengers = input.nextInt();
		int topFloor = input.nextInt();
		int[] floor = new int[numberOfPassengers];
		int[] time = new int[numberOfPassengers];
		for(int  a= 0; a < numberOfPassengers; a++){
			floor[a] = input.nextInt();
			time[a] = input.nextInt();
		}
		int max = -1;
		for(int a = 0; a < numberOfPassengers; a++){
			if(max < floor[a] + Math.max(topFloor-floor[a], time[a])){
				max = floor[a] + Math.max(topFloor-floor[a], time[a]);
			}
		}
		System.out.println(max);
	}

}
