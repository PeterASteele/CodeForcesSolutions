import java.util.Arrays;
import java.util.Scanner;

//http://codeforces.com/contest/608/problem/B
public class HammingDistanceSum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		String b = input.nextLine();
		int lengthA = a.length();
		int lengthB = b.length();
		int[] onesCountLeft = new int[lengthA];
		int[] onesCountRight = new int[lengthA];
		int totalOneCount = -1;
		int tempCounter = 0;
		for(int c = 0; c < lengthA; c++){
			if(a.charAt(c) == '1'){
				tempCounter++;
			}
			onesCountLeft[c] = tempCounter;
		}
		tempCounter = 0;
		for(int c = lengthA-1; c >= 0; c--){
			if(a.charAt(c) == '1'){
				tempCounter++;
			}
			onesCountRight[c] = tempCounter;
		}
		totalOneCount = onesCountRight[0];
		long sum = 0;
		if(lengthB == lengthA){
			for(int c = 0; c < lengthB; c++){
				if(a.charAt(c) != b.charAt(c)){
					sum++;
				}
			}
		}
		else if(lengthB < lengthA * 2){
			int[] freqOnesArray = new int[lengthB];
			int numMidValues = 2*lengthA - lengthB-2;
			int possibilitiesInMid = lengthB-lengthA+1;
			//System.out.println("There are " + numMidValues + " mid values");
			//System.out.println("There is " + possibilitiesInMid + " mid thickness");
			int freq1Count = 0;
			for(int c = 0; c < possibilitiesInMid ; c++){
				if(a.charAt(c) == '1'){
					freq1Count++;
				}
				freqOnesArray[c] = freq1Count;
				//System.out.print(freqOnesArray[c] + " ");
			}
			//System.out.println();
			for(int c = possibilitiesInMid; c <= possibilitiesInMid + numMidValues; c++){
			//	//System.out.println(" index " + c);
				if(a.charAt(c) == '1'){
			   // 	//System.out.println("adding " + c);
					freq1Count++;
				}
				if(a.charAt(c - possibilitiesInMid) == '1'){
					freq1Count--;
				//	//System.out.println("dropping " + (c- possibilitiesInMid));
				}
				freqOnesArray[c] = freq1Count;
				//System.out.print(freqOnesArray[c] + " ");
			}
			//System.out.println();
			for(int c = possibilitiesInMid + numMidValues+1; c < possibilitiesInMid + possibilitiesInMid + numMidValues; c++){
				if(a.charAt(c-possibilitiesInMid) == '1'){
					freq1Count--;
				}
				freqOnesArray[c] = freq1Count;
				//System.out.print(freqOnesArray[c] + " ");
			}
			////System.out.println();
			for(int c = 0; c < lengthB; c++){
				int temp = possibilitiesInMid;
				if(c < possibilitiesInMid){
					temp = c+1;
				}
				if(lengthB - possibilitiesInMid < c){
					temp = lengthB-c;
				}
				////System.out.println("temp is " + temp + " minus " + freqOnesArray[c]);
				sum += (b.charAt(c) == '0')?freqOnesArray[c]:temp-freqOnesArray[c];
			}
			
		}
		else{
			for(int c = 0; c < lengthA; c++){
				sum += (b.charAt(c) == '0')?onesCountLeft[c]:c+1-onesCountLeft[c];
				//System.out.println(c + " " + sum);
			}
			//System.out.println(sum);
			for(int c = 0; c < lengthB - lengthA*2; c++){
				int convertedB = lengthA + c;
				sum += (b.charAt(convertedB) == '0')?totalOneCount:lengthA-totalOneCount;
				//System.out.println(c + " " + sum);
			}
			//System.out.println(sum);
			for(int c = 0; c < lengthA; c++){
				int convertedA = c;
				int convertedB = lengthB-lengthA+c;
				sum += (b.charAt(convertedB) == '0')?onesCountRight[convertedA]:lengthA-c - onesCountRight[convertedA];
				//System.out.println(c + " " + sum);
			}
		}
		System.out.println(sum);
	}
}
