import java.util.Scanner;

/*
 * A. Arrays
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
You are given two arrays A and B consisting of integers, sorted in non-decreasing order. Check whether it is possible to choose k numbers in array A and choose m numbers in array B so that any number chosen in the first array is strictly less than any number chosen in the second array.

Input
The first line contains two integers nA, nB (1 ≤ nA, nB ≤ 10^5), separated by a space — the sizes of arrays A and B, correspondingly.

The second line contains two integers k and m (1 ≤ k ≤ nA, 1 ≤ m ≤ nB), separated by a space.

The third line contains nA numbers a1, a2, ... anA ( - 10^9 ≤ a1 ≤ a2 ≤ ... ≤ anA ≤ 109^), separated by spaces — elements of array A.

The fourth line contains nB integers b1, b2, ... bnB ( - 10^9 ≤ b1 ≤ b2 ≤ ... ≤ bnB ≤ 10^9), separated by spaces — elements of array B.

Output
Print "YES" (without the quotes), if you can choose k numbers in array A and m numbers in array B so that any number chosen in array A was strictly less than any number chosen in array B. Otherwise, print "NO" (without the quotes).
 */
public class Arrays {
	public static void main(String[] args){
		
		//get input.
		Scanner input = new Scanner(System.in);
		int size1 = input.nextInt();
		int size2 = input.nextInt();
		int[] array1 = new int[size1];
		int[] array2 = new int[size2];
		input.nextLine();
		int K = input.nextInt();
		int M = input.nextInt();
		input.nextLine();
		for(int a = 0; a < size1; a++){
			array1[a] = input.nextInt();
		}
		input.nextLine();
		for(int a = 0; a < size2; a++){
			array2[a] = input.nextInt();
		}
		input.nextLine();
		
		if(array1[K-1] < array2[size2-M]){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}
