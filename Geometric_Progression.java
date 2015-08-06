import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 
Polycarp loves geometric progressions very much. Since he was only three years old, he loves only the progressions of length three. He also has a favorite integer k and a sequence a, consisting of n integers.

He wants to know how many subsequences of length three can be selected from a, so that they form a geometric progression with common ratio k.

A subsequence of length three is a combination of three such indexes i1, i2, i3, that 1 ≤ i1 < i2 < i3 ≤ n. That is, a subsequence of length three are such groups of three elements that are not necessarily consecutive in the sequence, but their indexes are strictly increasing.

A geometric progression with common ratio k is a sequence of numbers of the form b·k0, b·k1, ..., b·kr - 1.

Polycarp is only three years old, so he can not calculate this number himself. Help him to do it.

Input
The first line of the input contains two integers, n and k (1 ≤ n, k ≤ 2·10^5), showing how many numbers Polycarp's sequence has and his favorite number.

The second line contains n integers a1, a2, ..., an ( - 10^9 ≤ ai ≤ 10^9) — elements of the sequence.

Output
Output a single number — the number of ways to choose a subsequence of length three, such that it forms a geometric progression with a common ratio k.
 */
public class Geometric_Progression {

	public static void main(String[] args) {
		
		//Gather inputs.
		Scanner input = new Scanner(System.in);
		int numberCases = input.nextInt();
		int favoriteNumber = input.nextInt();
		input.nextLine();
		int[] inputArray = new int[numberCases];
		for(int a = 0; a < numberCases; a++){
			inputArray[a] = input.nextInt();
		}
		input.nextLine();
		//we have all of the input.
		if(favoriteNumber > 40000){
			//we know that the ratio is so high that k^2 is above 10^9.
			//Because of this, the smallest possible non-zero series 1, k, k^2.
			//0, 0, 0 is still a series!
						
			int numberOfZeros = 0;
			for(int a = 0; a < numberCases; a++){
				if(inputArray[a] == 0){
					numberOfZeros++;
				}
			}
			BigInteger a = new BigInteger("" + numberOfZeros);
			//print N * N-1 * N-2 / 6, the number of subsequences of zeros.
			System.out.println(a.multiply(a.subtract(BigInteger.ONE)).multiply(a.subtract(new BigInteger("2"))).divide(new BigInteger("6")));
		}
		else{
			//Here's the plan. When we find a number, we add KA to a hashmap or increase it's value by 1 if it's there.
			//Once we find KA, we add KKA to a second hashmap with the total number of K's it had before. If KKA is already
			//In the second map, we incrase it's value by the value of KA in the first map. 
			//When we find KKA, we add simply add the value contained in KKA in the second map to the total.
			
			HashMap<Integer, Integer> hashMap2ndNumberFrequency = new HashMap<Integer, Integer>();
			HashMap<Integer, BigInteger> hashMap3rdNumberFrequency = new HashMap<Integer, BigInteger>(); 
			//we have to use bigInteger because they can get too big.
			
			BigInteger count = BigInteger.ZERO;
			for(int a = 0; a < numberCases; a++){
				BigInteger KA = new BigInteger("" + inputArray[a]).multiply(new BigInteger("" + favoriteNumber));
				//We need to check if this is possibility for the 3rd slot in the series.
				BigInteger check3 = hashMap3rdNumberFrequency.get(inputArray[a]);
				if(check3 != null){
					//System.out.println(check3);
					count = count.add(new BigInteger(check3 + ""));
				}
				if(((KA).abs()).compareTo(new BigInteger("2000000000")) <= 0){
					//Now, we need to go and check for promotions. IE, did we already have this number listed as a possibility for the 2nd integer?
					
					Integer check2 = hashMap2ndNumberFrequency.get(inputArray[a]);
					if(check2 != null){
						//we found the 3nd value of a series.
						//check if it is already there
						BigInteger checkPromo = hashMap3rdNumberFrequency.get(KA.intValue());
						if(checkPromo == null){
							hashMap3rdNumberFrequency.put(KA.intValue(), new BigInteger(check2 + ""));
						}
						else{
							hashMap3rdNumberFrequency.put(KA.intValue(), (new BigInteger(check2 + "")).add(checkPromo));
						}
					}
					
					//Add the possibilities for 2nd values to the series.
					Integer check = hashMap2ndNumberFrequency.get(KA.intValue());
					if(check == null){
						hashMap2ndNumberFrequency.put(KA.intValue(), 1);
					}
					else{
						hashMap2ndNumberFrequency.put(KA.intValue(), check + 1);
					}
					
					
				}
				else{
					//too big, move on.
				}
				
			}
			//print out the answer.
			System.out.println(count);
		}	
		
	}

}
