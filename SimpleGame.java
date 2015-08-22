import java.util.Scanner;
/*
 * B. Simple Game
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
One day Misha and Andrew were playing a very simple game. First, each player chooses an integer in the range from 1 to n. Let's assume that Misha chose number m, and Andrew chose number a.

Then, by using a random generator they choose a random integer c in the range between 1 and n (any integer from 1 to n is chosen with the same probability), after which the winner is the player, whose number was closer to c. The boys agreed that if m and a are located on the same distance from c, Misha wins.

Andrew wants to win very much, so he asks you to help him. You know the number selected by Misha, and number n. You need to determine which value of a Andrew must choose, so that the probability of his victory is the highest possible.

More formally, you need to find such integer a (1 ≤ a ≤ n), that the probability that  is maximal, where c is the equiprobably chosen integer from 1 to n (inclusive).

Input
The first line contains two integers n and m (1 ≤ m ≤ n ≤ 10^9) — the range of numbers in the game, and the number selected by Misha respectively.

Output
Print a single number — such value a, that probability that Andrew wins is the highest. If there are multiple such values, print the minimum of them.
 */
public class SimpleGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		if (N == 1 & M == 1) {
			System.out.println(1);
		} else {
			input.nextLine();
			double mid = (N + 1) / 2.0;
			if (M >= mid - 0.1) {
				// guard against rounding error. If there is a tie, we always
				// want M to be slightly larger.
				System.out.println(M - 1);
			} else {
				System.out.println(M + 1);
			}
		}
	}
}
