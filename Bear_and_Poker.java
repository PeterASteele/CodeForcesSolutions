import java.util.Scanner;

/*
 * C. Bear and Poker
time limit per test 2 seconds
memory limit per test 256 megabytes
input standard input
output standard output
Limak is an old brown bear. He often plays poker with his friends. Today they went to a casino. There are n players (including Limak himself) and right now all of them have bids on the table. i-th of them has bid with size ai dollars.

Each player can double his bid any number of times and triple his bid any number of times. The casino has a great jackpot for making all bids equal. Is it possible that Limak and his friends will win a jackpot?

Input
First line of input contains an integer n (2 ≤ n ≤ 10^5), the number of players.

The second line contains n integer numbers a1, a2, ..., an (1 ≤ ai ≤ 10^9) — the bids of players.

Output
Print "Yes" (without the quotes) if players can make their bids become equal, or "No" otherwise.
 */
public class Bear_and_Poker {
	static int[] power3 = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441}; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfPlayers = input.nextInt();
		input.nextLine();
		int[] inputBets = new int[numberOfPlayers];
		for(int a = 0; a < numberOfPlayers; a++){
			inputBets[a] = input.nextInt();
		}
		boolean flag = true;
		for(int a = 0; a < numberOfPlayers; a++){
			inputBets[a] = strip2(inputBets[a]);
			inputBets[a] = strip3(inputBets[a]);
			if(a != 0){
				if(inputBets[a] != inputBets[a-1]){
					System.out.println("No");
					flag = false;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Yes");
		}
	}
	public static int strip2(int a){
		if(a % (1 << 16) == 0){
			a = a / (1 << 16);
		}
		if(a % (1 << 8) == 0){
			a = a / (1 << 8);
		}
		if(a % (1 << 4) == 0){
			a = a / (1 << 4);
		}
		if(a % (1 << 2) == 0){
			a = a / (1 << 2);
		}
		if(a % (1 << 1) == 0){
			a = a / (1 << 1);
		}
		//just to be safe
		while(a % 2 == 0){
			a = a / 2;
		}
		return a;
	}
	public static int strip3(int a){
		if(a % power3[10] == 0){
			a = a / power3[10];
		}
		if(a % power3[8] == 0){
			a = a / power3[8];
		}
		if(a % power3[4] == 0){
			a = a / power3[4];
		}
		if(a % power3[2] == 0){
			a = a / power3[2];
		}
		if(a % power3[1] == 0){
			a = a / power3[1];
		}
		//just to be safe
		while(a % 3 == 0){
			a = a / 3;
		}
		return a;
	}
}
