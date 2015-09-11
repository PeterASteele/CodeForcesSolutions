import java.util.Arrays;
import java.util.Scanner;
/*
 * A. Bear and Elections
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
Limak is a grizzly bear who desires power and adoration. He wants to win in upcoming elections and rule over the Bearland.

There are n candidates, including Limak. We know how many citizens are going to vote for each candidate. Now i-th candidate would get ai votes. Limak is candidate number 1. To win in elections, he must get strictly more votes than any other candidate.

Victory is more important than everything else so Limak decided to cheat. He will steal votes from his opponents by bribing some citizens. To bribe a citizen, Limak must give him or her one candy - citizens are bears and bears like candies. Limak doesn't have many candies and wonders - how many citizens does he have to bribe?

Input
The first line contains single integer n (2 ≤ n ≤ 100) - number of candidates.

The second line contains n space-separated integers a1, a2, ..., an (1 ≤ ai ≤ 1000) - number of votes for each candidate. Limak is candidate number 1.

Note that after bribing number of votes for some candidate might be zero or might be greater than 1000.

Output
Print the minimum number of citizens Limak must bribe to have strictly more votes than any other candidate.
 */

public class Bear_and_Elections {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int canidates = input.nextInt();
		input.nextLine();
		int[] votes = new int[canidates-1];
		int bearVotes = input.nextInt();
		for(int a = 0; a < canidates-1; a++){
			votes[a] = input.nextInt();
		}
		
		input.nextLine();
		int stolenVotes = 0;
		Arrays.sort(votes);
		int temp = 0;
		while(votes[canidates-2] >= bearVotes){
			temp = 1;
			stolenVotes += temp;
			bearVotes += temp;
			votes[canidates-2] -= temp;
			Arrays.sort(votes);
		}
		System.out.println(stolenVotes);
		
	}
}
