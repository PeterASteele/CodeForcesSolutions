import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Multipliers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numberOfPrimes = input.nextInt();
		SegmentTree holdPrimes = new SegmentTree(0, 200001);//segmentTree holding multiplication in log(n) time
		int[] primes = new int[200001];
		for(int a = 0; a < numberOfPrimes; a++){
			int temp = input.nextInt();
			primes[temp]++;                             //make frequency distribution of primes
		}		
		for(int a = 0; a < primes.length; a++){
			holdPrimes.insert(a, primes[a]+1);
		}
		long bigProduct = 1;
		for(int a = 0; a < 200001; a++){
			if(primes[a] != 0){
				long primeNth = takePrimeNth(a, primes[a]);
				long numPossibilities = (holdPrimes.rangeQuery(0, a-1)*(holdPrimes.rangeQuery(a+1, 200001)));
				long result = (nthPow(primeNth, new BigInteger(numPossibilities + "")))%1000000007;
				bigProduct = (bigProduct * result) % 1000000007;
			}
		}
		System.out.println(bigProduct);		
	}	
	private static long takePrimeNth(int prime, int power) {
		long tempPower = power;
		tempPower = (tempPower * (tempPower+1)) / 2;
		return nthPow(prime, new BigInteger(tempPower + "")); 
	}
	private static long nthPow(long prime, BigInteger numPossibilities) {
		if(numPossibilities.equals(BigInteger.ZERO)){
			return 1;
		}
		if(numPossibilities.equals(BigInteger.ONE)){
			return prime;
		}
		long temp = nthPow(prime, numPossibilities.divide(new BigInteger("2")));
		long temp2 = (temp * temp) %1000000007;
		return (temp2 * nthPow(prime, numPossibilities.mod(new BigInteger(2+""))))%1000000007;
	}
	public static class SegmentTree{
		int left;
		int right;
		SegmentTree leftTree;
		SegmentTree rightTree;
		long product;
		public SegmentTree(int left, int right){
			product = 1;
			this.left = left;
			this.right = right;
			if(left != right){
				leftTree = new SegmentTree(left, left + (right-left)/2);
				rightTree = new SegmentTree(left + (right-left)/2+1, right);
			}
		}
		public void insert(int location, int prime){
			if(left <= location && right >= location){
				product *= prime;
				product = product%1000000006;
				if(left != right){
					leftTree.insert(location, prime);
					rightTree.insert(location, prime);
				}
			}
		}
		public long rangeQuery(int leftQuery, int rightQuery){
			if(leftQuery <= left && rightQuery >= right){
				return product;
			}
			if(leftQuery > right || rightQuery < left){
				return 1;
			}
			if(left != right){
				return (leftTree.rangeQuery(leftQuery, rightQuery) * rightTree.rangeQuery(leftQuery, rightQuery)) % 1000000006;
			}
			return 1;
		}
		public String toString(){
			if(left == right){
				return "Left: " + left + " Right: " + right + " Product: " + product +"\n";
			}
			else{
				return "Left: " + left + " Right: " + right + " Product: " + product +"\n" + leftTree.toString() + rightTree.toString();
			}
		}
	}
}
