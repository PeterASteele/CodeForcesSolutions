import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/707/C
public class PythagoreanTriples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long n = input.nextInt();
		if(n == 1 || n == 2){
			System.out.println(-1);
			return;
		}
		long mult = 1;
		while(n%2 == 0){
			n = n/2;
			mult = mult*2;
		}
		if(n == 1){
			mult = mult/4;
			n = 4;
			System.out.println(3*mult + " " + 5*mult);			
		}
		else{
			long x = ((n*n)-1)/2;
			long x2 = x+1;
			System.out.println(x*mult + " " + x2*mult);
		}
	}
}