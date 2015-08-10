import java.util.ArrayList;
import java.util.Scanner;

/*
 * C. Primes or Palindromes?
time limit per test3 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Rikhail Mubinchik believes that the current definition of prime numbers is obsolete as they are too complex and unpredictable. A palindromic number is another matter. It is aesthetically pleasing, and it has a number of remarkable properties. Help Rikhail to convince the scientific community in this!

Let us remind you that a number is called prime if it is integer larger than one, and is not divisible by any positive integer other than itself and one.

Rikhail calls a number a palindromic if it is integer, positive, and its decimal representation without leading zeros is a palindrome, i.e. reads the same from left to right and right to left.

One problem with prime numbers is that there are too many of them. Let's introduce the following notation: π(n) — the number of primes no larger than n, rub(n) — the number of palindromic numbers no larger than n. Rikhail wants to prove that there are a lot more primes than palindromic ones.

He asked you to solve the following problem: for a given value of the coefficient A find the maximum n, such that π(n) ≤ A·rub(n).

Input
The input consists of two positive integers p, q, the numerator and denominator of the fraction that is the value of A (p/q).
p,q <= 10^4, 1/42 <= p/q <= 42
Output
If such maximum number exists, then print it. Otherwise, print "Palindromic tree is better than splay tree" (without the quotes).
 */
public class Primes_Or_Palindromes {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int p = input.nextInt();
		int q = input.nextInt();
		input.nextLine();
		double factor = p / (q+0.0);
		int upperBound = 1200000; 
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		int primeCount = 2;
		int palindromeCount = 3;
		int max = -1;
		int temp = 4;
		while(temp < upperBound){
			boolean check = true;
			for(Integer a: primes){
				if(a > Math.sqrt(temp)){
					break;
				}
				if (temp%(a + 0.0) == 0){
					check = false;
					break;
				}
			}
			if(check){
				primes.add(temp);
				primeCount++;
			}		
			if(palindromeCheck(temp + "")){
				palindromeCount++;
			}
			if(primeCount <= factor * palindromeCount){
				max = temp;
			}
			temp++;
		}
		if(max == -1){
			if(factor >= .66666666){
				max = 3;
			}
			else if(factor >= .5){
				max = 2;
			}
			else{
				max = 1;
			}			
		}
		if(max == 1000000){
			System.out.println("Palindromic tree is better than splay tree");
		}
		else{
			System.out.println(max);
		}
	}
	public static boolean palindromeCheck(String a){
		if(a.length() < 2){
			return true;
		}
		if(a.charAt(0) == a.charAt(a.length() - 1)){
			return palindromeCheck(a.substring(1, a.length() - 1));
		}
		return false;
	}
}
