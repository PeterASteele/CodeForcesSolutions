import java.util.Scanner;
/*
B. Inventory
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
Companies always have a lot of equipment, furniture and other things. All of them should be tracked. To do this, there is an inventory number assigned with each item. It is much easier to create a database by using those numbers and keep the track of everything.

During an audit, you were surprised to find out that the items are not numbered sequentially, and some items even share the same inventory number! There is an urgent need to fix it. You have chosen to make the numbers of the items sequential, starting with 1. Changing a number is quite a time-consuming process, and you would like to make maximum use of the current numbering.

You have been given information on current inventory numbers for n items in the company. Renumber items so that their inventory numbers form a permutation of numbers from 1 to n by changing the number of as few items as possible. Let us remind you that a set of n numbers forms a permutation if all the numbers are in the range from 1 to n, and no two numbers are equal.

Input
The first line contains a single integer n — the number of items (1 ≤ n ≤ 10^5).

The second line contains n numbers a1, a2, ..., an (1 ≤ ai ≤ 10^5) — the initial inventory numbers of the items.

Output
Print n numbers — the final inventory numbers of the items in the order they occur in the input. If there are multiple possible answers, you may print any of them.
*/
public class Inventory {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numberOfItems = input.nextInt();
		input.nextLine();
		int[] items = new int[numberOfItems];
		int[] flags = new int[numberOfItems];
		int[] frequencyDistribution = new int[numberOfItems + 1];
		for(int a = 0; a < numberOfItems; a++){
			items[a] = input.nextInt();
			flags[a] = 1;
			if(items[a] > numberOfItems){
				items[a] = 0;
			}
			frequencyDistribution[items[a]]++;
		}
		
		boolean finished = false;
		int indexAdd = 1;
		int index = 0;
		while(index < numberOfItems){
			if(frequencyDistribution[items[index]] > 1 || items[index] == 0){
				frequencyDistribution[items[index]]--;
				while(frequencyDistribution[indexAdd] != 0){
					indexAdd++;
				}
				frequencyDistribution[indexAdd]++;
				items[index] = indexAdd;
				//we need to migrate this item.
			}
			System.out.print(items[index] + " ");
			index++;
		}
		System.out.println();		
	}
}
