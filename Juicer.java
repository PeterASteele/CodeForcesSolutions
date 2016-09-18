import java.util.Scanner;
//http://codeforces.com/problemset/problem/709/A
public class Juicer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int b = input.nextInt();
		int d = input.nextInt();
		int[] arr = new int[n];
		for(int a = 0; a < n; a++){
			arr[a] = input.nextInt();
		}
		long total = 0;
		int count = 0;
		for(int a = 0; a < n; a++){
			if(arr[a] > b){
				continue;
			}
			if(total+arr[a] > d){
				count++;
				total += arr[a];
				total = 0;
			}
			else{
				total += arr[a];
			}
		}
		System.out.println(count);
	}
}