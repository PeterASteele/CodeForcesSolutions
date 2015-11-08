import java.util.Scanner;


public class PashaAndPhone {
//http://codeforces.com/contest/595/problem/B
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int phoneNumberLength = input.nextInt();
		int blockLength = input.nextInt();
		int[] sequenceA = new int[phoneNumberLength/blockLength];
		int[] sequenceB = new int[phoneNumberLength/blockLength];
		for(int a = 0; a < phoneNumberLength/blockLength; a++){
			sequenceA[a] = input.nextInt();
		}
		for(int a = 0; a < phoneNumberLength/blockLength; a++){
			sequenceB[a] = input.nextInt();
		}
		long result = 1;
		for(int a = 0; a < phoneNumberLength/blockLength; a++){
			long blockPossibilities = 0;
			long total = (long) Math.pow(10, blockLength);
			long totalDivisible =(long) (Math.ceil(((double) total)/sequenceA[a]));
			long totalTemp = total/10;
			long lowerLimit = totalTemp * sequenceB[a];
			long upperLimit = totalTemp * sequenceB[a] + totalTemp;
			blockPossibilities = totalDivisible - (long)(Math.ceil(((double) upperLimit)/sequenceA[a])- Math.ceil(((double) lowerLimit)/sequenceA[a]));
			result = result * blockPossibilities;
			//System.out.println(blockPossibilities + " " + totalDivisible + " " + (upperLimit/sequenceA[a]) + " " + (lowerLimit/sequenceA[a]));
			result = result % 1000000007;
		}
		System.out.println(result);
	}

}
