import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;


public class AProblemAboutPolyline {
/*
 * A. A Problem about Polyline
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
There is a polyline going through points (0, 0) – (x, x) – (2x, 0) – (3x, x) – (4x, 0) – ... - (2kx, 0) – (2kx + x, x) – ....

We know that the polyline passes through the point (a, b). Find minimum positive value x such that it is true or determine that there is no such x.

Input
Only one line containing two positive integers a and b (1 ≤ a, b ≤ 10^9).

Output
Output the only line containing the answer. Your answer will be considered correct if its relative or absolute error doesn't exceed 10 - 9. If there is no such x then output  - 1 as the answer.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
		Scanner input = new Scanner(System.in);
		int X = input.nextInt();
		int Y = input.nextInt();
		if(Y>X){
			System.out.println(-1);
		}
		else{
			//get closer. First try answer = y.
			BigDecimal answer = new BigDecimal(Y);
			BigDecimal temp = new BigDecimal(X);
			temp = temp.subtract(answer); //distance from point to first peak.
			BigDecimal total = (temp.divide(answer.multiply(new BigDecimal(2)), mc));
			//System.out.println(total + " is the total ");
			total = total.setScale(0, RoundingMode.DOWN);
			//System.out.println(total + " is the total ");
			BigDecimal closeness =  temp.subtract((total.multiply(answer.multiply(new BigDecimal(2)))));
			//System.out.println(closeness);
			int count = 0;
			while(true){
				//System.out.println(answer);
				//System.out.println("Answer is " + answer + " closeness " + closeness);
				count++;
				if(count > 1000){
					break;
				}
				BigDecimal tempAnswer = new BigDecimal(0);
				BigDecimal tempValue = answer.subtract(((answer.multiply(new BigDecimal(2))).subtract(closeness)).divide(((total.multiply(new BigDecimal(2))).add(new BigDecimal(1.0))), mc));
				BigDecimal tempValue2 = (answer.add((closeness).divide(((total.multiply(new BigDecimal(2))).add(new BigDecimal(1.0))), mc)));
				//System.out.println("subtract value would be " + tempValue);
				//System.out.println("add value would be " + tempValue2);
				if(closeness.compareTo(answer) > 0 || tempValue.compareTo(new BigDecimal(Y)) < 0){
					tempAnswer = tempValue2;
				}
				else{
					tempAnswer = tempValue;
				}
				answer = (answer.add(tempAnswer)).divide(new BigDecimal(2.0), mc);
				temp = new BigDecimal(X);
				temp = temp.subtract(answer); //distance from point to first peak.
				total = temp.divide(answer.multiply(new BigDecimal(2)), mc);
				total = total.setScale(0, RoundingMode.DOWN);
				closeness =  temp.subtract(total.multiply(answer.multiply(new BigDecimal(2)))).subtract((answer.subtract(new BigDecimal(Y))));
				
			}
			System.out.println(answer);
		}
		
	}

}
