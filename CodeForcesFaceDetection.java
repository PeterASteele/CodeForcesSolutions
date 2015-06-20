import java.util.Scanner;


public class CodeForcesFaceDetection{
	/*
	 * A. 
	 * Face Detection
time limit per test 1 second
memory limit per test 256 megabytes
inputstandard input
outputstandard output
The developers of Looksery have to write an efficient algorithm that detects faces on a picture. Unfortunately, they are currently busy preparing a contest for you, so you will have to do it for them.

In this problem an image is a rectangular table that consists of lowercase Latin letters. A face on the image is a 2 × 2 square, such that from the four letters of this square you can make word "face".

You need to write a program that determines the number of faces on the image. The squares that correspond to the faces can overlap.

Input
The first line contains two space-separated integers, n and m (1 ≤ n, m ≤ 50) — the height and the width of the image, respectively.

Next n lines define the image. Each line contains m lowercase Latin letters.

Output
In the single line print the number of faces on the image.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numberOfStudents = input.nextInt();
		input.nextLine(); //clear to next line;
		String line = input.nextLine();//get all the data
		String[] ranks = line.split(" ");
		
		int[] ranksInt = new int[ranks.length];
		for(int a = 0; a < ranks.length; a++){
			ranksInt[a] = Integer.parseInt(ranks[a]);
		}
		int[] finalRank = new int[ranks.length];
		int count2 = 1;
		int count = 1;
		for(int a = ranksInt.length; a > 0; a--){
			for(int b = 0; b < ranksInt.length; b++){
				if(ranksInt[b] == a){
					count2++;
					finalRank[b] = count;
				}
			}
			count = count2;
		}
		for(int a = 0; a < finalRank.length; a++){
			System.out.print(finalRank[a] + " ");
		}
	}

}
