import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * D. Bear and Blocks
time limit per test1 second
memory limit per test256 megabytes
input standard input
output standard output
Limak is a little bear who loves to play. Today he is playing by destroying block towers. He built n towers in a row. The i-th tower is made of hi identical blocks. For clarification see picture for the first sample.
Limak will repeat the following operation till everything is destroyed.

Block is called internal if it has all four neighbors, i.e. it has each side (top, left, down and right) adjacent to other block or to the floor. Otherwise, block is boundary. In one operation Limak destroys all boundary blocks. His paws are very fast and he destroys all those blocks at the same time.
Limak is ready to start. You task is to count how many operations will it take him to destroy all towers.

Input
The first line contains single integer n (1 ≤ n ≤ 10^5).
The second line contains n space-separated integers h1, h2, ..., hn (1 ≤ hi ≤ 10^9) — sizes of towers.

Output
Print the number of operations needed to destroy all towers.
 */

public class Bear_and_Blocks {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String line = br.readLine();
			int size = Integer.parseInt(line);
			//System.out.println(line);
			String line2 = br.readLine();
			//System.out.println(line2);
			StringTokenizer st = new StringTokenizer(line2);
			int[] inputArray = new int[size];
			for(int a = 0; a < size; a++){
				inputArray[a] = Integer.parseInt(st.nextToken());
				if(inputArray[a] > 100000){
					inputArray[a] = 100000;
				}
			}
			int[] trackArray = new int[size];
			for(int a = 0; a < size; a++){
				trackArray[a] = 1000000;
			}
			trackArray[0] = 1;
			trackArray[size - 1] = 1;
			for(int a = 1; a < size; a++){
				trackArray[a] = Math.min(Math.min(trackArray[a-1] + 1, inputArray[a]), trackArray[a]);
				trackArray[size - 1 - a] = Math.min(Math.min(trackArray[size - a] + 1, inputArray[size - 1 - a]), trackArray[size - 1 - a]);
			}
			if(size % 2 == 1 && size > 1){
				trackArray[size/2] = Math.min(Math.min(trackArray[size/2 - 1] + 1, trackArray[size/2 + 1] + 1), inputArray[size/2]);
			}
			//we have the end
			
			int max = -1;
			for(int a = 0; a < size; a++){
				if(max < trackArray[a]){
					max = trackArray[a];
				}
			}
			System.out.println(max);
			//debug(trackArray);
		}
		catch(Exception e){
			//The classic exception handle
			//System.out.println("CRAP");
		}
	}	
	public static void debug(int[] test){
		for(int a = 0; a < test.length; a++){
			System.out.print(test[a] + " ");
		}
		System.out.println();
	}
}
