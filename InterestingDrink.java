import java.util.Arrays;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/706/B
public class InterestingDrink {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for(int a = 0; a < n; a++){
			arr[a] = input.nextInt();
		}
		Arrays.sort(arr);
		int q = input.nextInt();
		for(int a = 0; a < q; a++){
			int temp = input.nextInt();
			int answer = binarySearch(arr, 0, arr.length, temp);
			System.out.println(answer);
		}
	}

	private static int binarySearch(int[] arr, int left, int right, int temp) {
		if(left + 1 >= right){
			if(arr[left] <= temp){
				return right;
			}
			else{
				return left;
			}
		}
		int mid = (left + right)/2;
		if(arr[mid] <= temp){
			return binarySearch(arr, mid, right, temp);
		}
		else{
			return binarySearch(arr, left, mid, temp);
		}
	}
}