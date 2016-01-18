import java.math.BigInteger;
import java.util.Scanner;

//http://codeforces.com/contest/611/problem/B
public class NewYearAndOldProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String start = input.next();
		String end = input.next();
		BigInteger startBig = new BigInteger(start);
		BigInteger endBig = new BigInteger(end);
		String startBin = startBig.toString(2);
		String endBin = endBig.toString(2);
		//System.out.println(startBin + " " + endBin);
		int lengthDifference = endBin.length() - startBin.length() - 1;
		if(lengthDifference == -1){
			int afterStart = getSpotsRightOfFirst0(startBin);
			int beforeEnd = getSpotsLeftOfFirst0(endBin);
			//System.out.println(afterStart);
			//System.out.println(beforeEnd);
			System.out.println((afterStart+beforeEnd-(startBin.length()-1) + hasOne0(endBin)));
		}
		else{
			int solidCount = 0;
			for(int a = 0; a < lengthDifference; a++){
				solidCount += startBin.length()+a;
			}
			System.out.println(hasOne0(endBin)+solidCount+getSpotsLeftOfFirst0(endBin) + getSpotsRightOfFirst0(startBin));
		}
		
	}
	public static int hasOne0(String input){
		int number = getNumberOf0s(input);
		if(number == 1){
			return 1;
		}
		else{
			return 0;
		}
	}
	public static int getNumberOf0s(String input){
		int sum = 0;
		for(int a = 0; a < input.length(); a++){
			if(input.charAt(a) == '0'){
				sum++;
			}
		}
		return sum;
	}
	public static int getSpotsLeftOfFirst0(String input){
		int total = 0;
		for(int a = 1; a < input.length(); a++){
			if(input.charAt(a) == '1'){
				total++;
			}
			else{
				break;
			}
		}
		return total;
	}
	public static int getSpotsRightOfFirst0(String input){
		int total = getSpotsLeftOfFirst0(input);
		////System.out.println("total is " + total);
		return input.length()-total-1;
	}
}
