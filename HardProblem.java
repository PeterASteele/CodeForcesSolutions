import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/706/C
public class HardProblem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long[] cost = new long[n];
		for(int a = 0; a < n; a++){
			cost[a] = input.nextInt();
		}
		String[] arr1 = new String[n];
		String[] arr2 = new String[n];
		for(int a = 0; a < n; a++){
			String temp = input.next();
			String tempReverse = new StringBuilder(temp).reverse().toString();
			arr1[a] = temp;
			arr2[a] = tempReverse;
		}
		
		//dynamic programming
//		System.out.println(Arrays.toString(arr1));
//		System.out.println(Arrays.toString(arr2));
//		System.out.println(Arrays.toString(cost));
		long startDynamicCost = 0;
		String earliestAlphabet = "";
		long startDynamicCost2 = 0;
		String earliestAlphabet2 = "";
		for(int a = 0; a < n; a++){
			
			ArrayList<Long> possibilities = new ArrayList<Long>();
			if(arr1[a].compareTo(earliestAlphabet) >= 0){
				possibilities.add(startDynamicCost);
			}
			if(arr1[a].compareTo(earliestAlphabet2) >= 0){
				possibilities.add(startDynamicCost2);
			}
			Collections.sort(possibilities);
			
			
			
			ArrayList<Long> possibilities2 = new ArrayList<Long>();
			if(arr2[a].compareTo(earliestAlphabet) >= 0){
				possibilities2.add(startDynamicCost+cost[a]);
			}
			if(arr2[a].compareTo(earliestAlphabet2) >= 0){
				possibilities2.add(startDynamicCost2+cost[a]);
			}
			Collections.sort(possibilities2);
			
			if(possibilities.size() == 0){
				startDynamicCost = Long.MAX_VALUE/2;
				earliestAlphabet = arr1[a];
			}
			else{
				startDynamicCost = possibilities.get(0);
				earliestAlphabet = arr1[a];
			}
			
			if(possibilities2.size() == 0){
				startDynamicCost2 = Long.MAX_VALUE/2;
				earliestAlphabet2 = arr2[a];
			}
			else{
				startDynamicCost2 = possibilities2.get(0);
				earliestAlphabet2 = arr2[a];
			}
			
//			System.out.println(startDynamicCost + " " + earliestAlphabet + "\n" + startDynamicCost2 + " " + earliestAlphabet2 + "\n");
		}
		if(startDynamicCost < Long.MAX_VALUE/2 - 1 || startDynamicCost2 < Long.MAX_VALUE/2 - 1){
			System.out.println(Math.min(startDynamicCost, startDynamicCost2));
		}
		else{
			System.out.println(-1);
		}
	}

}