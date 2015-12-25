import java.util.Scanner;

//http://codeforces.com/contest/604/problem/C
public class AlternativeThinking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numberOfCases = input.nextInt(); input.nextLine();
		int[] stuff = new int[numberOfCases];
		String longString = input.nextLine();
		for(int a = 0; a < numberOfCases; a++){
			stuff[a] = longString.charAt(a) - '0';
		}
		boolean conseq3 = false;
		for(int a = 0; a < numberOfCases-2; a++){
			if(stuff[a] == stuff[a+1] && stuff[a+1] == stuff[a+2]){
				conseq3 = true;
			}
		}
		boolean conseq2 = false;
		boolean conseq2b = false;
		for(int a = 0; a < numberOfCases-1; a++){
			if(stuff[a] == stuff[a+1]){
				if(conseq2 == true){
					conseq2b = true;
				}
				conseq2 = true;
			}
		}
		int currentTotal = 1;
		for(int a = 1; a < numberOfCases; a++){
			if(stuff[a] != stuff[a-1]){
				currentTotal++;
			}
		}
		if(conseq3 || (conseq2 && conseq2b)){
			System.out.println(currentTotal+2);
		}
		else{
			if(conseq2){
				System.out.println(currentTotal+1);
			}
			else{
				System.out.println(currentTotal);
			}
		}
	}

}
