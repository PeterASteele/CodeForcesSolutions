import java.util.Scanner;

/*
 * B. Bear and Three Musketeers
time limit per test 2 seconds
memory limit per test 256 megabytes
inputstandard input
outputstandard output
Do you know a story about the three musketeers? Anyway, you will learn about its origins now.

Richelimakieu is a cardinal in the city of Bearis. He is tired of dealing with crime by himself. He needs three brave warriors to help him to fight against bad guys.

There are n warriors. Richelimakieu wants to choose three of them to become musketeers but it's not that easy. The most important condition is that musketeers must know each other to cooperate efficiently. And they shouldn't be too well known because they could be betrayed by old friends. For each musketeer his recognition is the number of warriors he knows, excluding other two musketeers.

Help Richelimakieu! Find if it is possible to choose three musketeers knowing each other, and what is minimum possible sum of their recognitions.

Input
The first line contains two space-separated integers, n and m (3 ≤ n ≤ 4000, 0 ≤ m ≤ 4000) — respectively number of warriors and number of pairs of warriors knowing each other.

i-th of the following m lines contains two space-separated integers ai and bi (1 ≤ ai, bi ≤ n, ai ≠ bi). Warriors ai and bi know each other. Each pair of warriors will be listed at most once.

Output
If Richelimakieu can choose three musketeers, print the minimum possible sum of their recognitions. Otherwise, print "-1" (without the quotes).
 */
public class Bear_and_Three_Musketeers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfWarriors = input.nextInt();
		int warriorPairs = input.nextInt();
		int[][] knows = new int[numberOfWarriors][numberOfWarriors];
		int[] recognition = new int[numberOfWarriors];
		for(int a = 0; a < warriorPairs; a++){
			int c = input.nextInt();
			int b = input.nextInt();
			//System.out.println(c + " " + b);
			knows[c-1][b-1] = 1;
			knows[b-1][c-1] = 1;
			recognition[c-1]++;
			recognition[b-1]++;
		}
		int minSum = Integer.MAX_VALUE;
		for(int a = 0; a < numberOfWarriors; a++){
			for(int b = a; b < numberOfWarriors; b++){
				if(knows[a][b] == 1){
					for(int c = b; c < numberOfWarriors; c++){
						//System.out.println(a + " " + b + " " + c + " MAX is " + numberOfWarriors);
						if(knows[b][c] == 1){
							if(knows[a][c] == 1){
								int temp = recognition[a] + recognition[b] + recognition[c];
								if(temp < minSum){
									minSum = temp;
								}
							}
						}
					}
				}
			}
		}
		if(minSum == Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			System.out.println(minSum - 6); //6 for the other two musketeers
		}	
	}

}
