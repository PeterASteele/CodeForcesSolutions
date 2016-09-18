import java.math.BigInteger;
import java.util.Scanner;
//http://codeforces.com/problemset/problem/711/E
public class ZSANDPARADOX {
	static long MOD = 1000003;
	static long MODEX = 1000002;
	static long InverseOf2 = 500002;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long N = input.nextLong();
		long K = input.nextLong();
		if (N < 100 && BigInteger.valueOf(2).pow((int)N).compareTo(BigInteger.valueOf(K)) < 0) {
			System.out.println(1 + " " + 1);
		} else {
			long K2 = K - 1;
			long number2Numerator = getTwoInFactorial(K2);
			BigInteger Num = BigInteger.valueOf(N);
			BigInteger KBigInteger = BigInteger.valueOf(K2);
			BigInteger product = Num.multiply(KBigInteger);
			BigInteger denominatorExponent = product.subtract(BigInteger.valueOf(number2Numerator));
			BigInteger denominator = BigInteger.valueOf(2).modPow(denominatorExponent, BigInteger.valueOf(MOD));
			// we have the denominator.
			
			if(K > MOD){
				BigInteger numerator = denominator;
				System.out.print(numerator + " ");
			}
			else{
				BigInteger start = BigInteger.ONE;

				BigInteger twoToNMod = BigInteger.valueOf(2).modPow(Num, BigInteger.valueOf(MOD));
				for(int kprime=1; kprime < K; kprime++){
					BigInteger num = twoToNMod.add(BigInteger.ZERO);
					num = num.subtract(BigInteger.valueOf(kprime));
					start = start.multiply(num);
					start = start.mod(BigInteger.valueOf(MOD));
				}
				//divide out the 2's
				BigInteger num2 = BigInteger.valueOf(number2Numerator).mod(BigInteger.valueOf(1000002));
				int twoCount = num2.intValue();
				for(int a = 0; a < twoCount; a++){
					start = start.multiply(BigInteger.valueOf(InverseOf2));
					start = start.mod(BigInteger.valueOf(MOD));
				}
				
				
				System.out.print(denominator.add(BigInteger.valueOf(MOD)).subtract(start).mod(BigInteger.valueOf(MOD)) + " ");
			}
			
			System.out.println(denominator);
		}
	}

	private static long getTwoInFactorial(long k2) {
		long total = 0;
		for (long start = 2; start <= k2; start = start * 2) {
			total += k2 / start;
		}
		return total;
	}
}