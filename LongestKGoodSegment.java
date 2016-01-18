import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

//http://codeforces.com/contest/616/problem/D
public class LongestKGoodSegment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int differentNumbers = input.nextInt();
		int[] numbers = new int[n];
		for(int a = 0; a < n; a++){
			numbers[a] = input.nextInt();
		}
		
		int[] freqDist = new int[1000005];
		int num = 0;
		int start = 0;
		int recordLength = 0;
		int recordStart = -1;
		int recordEnd = -1;
		for(int b = 0; b < n; b++){
			freqDist[numbers[b]]++;
			if(freqDist[numbers[b]] == 1){
				num++;
			}
			if(num <= differentNumbers){
				//record possibility
				if(recordLength < b - start + 1){
					recordLength = b - start + 1;
					recordStart = start;
					recordEnd = b;
				}
			}
			while(num > differentNumbers){
				freqDist[numbers[start]]--;
				if(freqDist[numbers[start]] == 0){
					num--;
				}
				start++;
			}			
		}
		System.out.println((recordStart+1) + " " + (recordEnd+1));
		
		
	}
}
