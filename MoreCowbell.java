import java.util.Scanner;
//Note: This solution got hacked/post tested; I believe it is due to cases with very few boxes relative to cowbells.
//http://codeforces.com/contest/604/problem/B
public class MoreCowbell {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int cowbells = input.nextInt();
		int boxes = input.nextInt();
		int[] cowSize = new int[cowbells];
		for(int a = 0; a < cowbells; a++){
			cowSize[a] = input.nextInt();
		}
		int[] box = new int[boxes];
		for(int a = 0; a < boxes; a++){
			box[a] = cowSize[cowbells-a-1];
		}
		for(int a = 0; a < cowbells - boxes; a++){
			box[a+boxes*2-cowbells] += cowSize[a];
		}
		int max = -1;
		for(int a = 0; a < boxes; a++){
			if(max < box[a]){
				max = box[a];
			}
		}
		System.out.println(max);
	}

}
