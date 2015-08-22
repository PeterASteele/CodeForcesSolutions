import java.util.Scanner;

/*
 * A. Elections
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
The country of Byalechinsk is running elections involving n candidates. The country consists of m cities. We know how many people in each city voted for each candidate.

The electoral system in the country is pretty unusual. At the first stage of elections the votes are counted for each city: it is assumed that in each city won the candidate who got the highest number of votes in this city, and if several candidates got the maximum number of votes, then the winner is the one with a smaller index.

At the second stage of elections the winner is determined by the same principle over the cities: the winner of the elections is the candidate who won in the maximum number of cities, and among those who got the maximum number of cities the winner is the one with a smaller index.

Determine who will win the elections.

Input
The first line of the input contains two integers n, m (1 ≤ n, m ≤ 100) — the number of candidates and of cities, respectively.

Each of the next m lines contains n non-negative integers, the j-th number in the i-th line aij (1 ≤ j ≤ n, 1 ≤ i ≤ m, 0 ≤ aij ≤ 10^9) denotes the number of votes for candidate j in city i.

It is guaranteed that the total number of people in all the cities does not exceed 10^9.

Output
Print a single number — the index of the candidate who won the elections. The candidates are indexed starting from one.
 */
public class Elections {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numberOfCanidates = input.nextInt();
		int numberOfCities = input.nextInt();
		int[] winners = new int[numberOfCanidates];
		int[][] votes = new int[numberOfCities][numberOfCanidates];
		
		for(int a = 0; a < numberOfCities; a++){
			for(int b = 0; b < numberOfCanidates; b++){
				votes[a][b] = input.nextInt();
			}
		}
		
		for(int a = 0; a < numberOfCities; a++){
			int max = -1; 
			int maxIndex = -1;
			for(int b = 0; b < numberOfCanidates; b++){
				if(max < votes[a][b]){
					max = votes[a][b];
					maxIndex = b;
				}
			}
			winners[maxIndex]++;
		}
		
		int max = -1;
		int winningIndex = -1;
		for(int a = 0; a < numberOfCanidates; a++){
			if(max < winners[a]){
				max = winners[a];
				winningIndex = a;
			}
		}
		System.out.println(winningIndex + 1);
	}
}
