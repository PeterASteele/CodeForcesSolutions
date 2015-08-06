import java.util.Scanner;

/*
 * B. Berland National Library
time limit per test 1 second
memory limit per test 256 megabytes
inputstandard input
outputstandard output
Berland National Library has recently been built in the capital of Berland. In addition, in the library you can take any of the collected works of Berland leaders, the library has a reading room.

Today was the pilot launch of an automated reading room visitors' accounting system! The scanner of the system is installed at the entrance to the reading room. It records the events of the form "reader entered room", "reader left room". Every reader is assigned a registration number during the registration procedure at the library — it's a unique integer from 1 to 10^6. Thus, the system logs events of two forms:

"+ ri" — the reader with registration number ri entered the room;
"- ri" — the reader with registration number ri left the room.
The first launch of the system was a success, it functioned for some period of time, and, at the time of its launch and at the time of its shutdown, the reading room may already have visitors.

Significant funds of the budget of Berland have been spent on the design and installation of the system. Therefore, some of the citizens of the capital now demand to explain the need for this system and the benefits that its implementation will bring. Now, the developers of the system need to urgently come up with reasons for its existence.

Help the system developers to find the minimum possible capacity of the reading room (in visitors) using the log of the system available to you.

Input
The first line contains a positive integer n (1 ≤ n ≤ 100) — the number of records in the system log. Next follow n events from the system journal in the order in which the were made. Each event was written on a single line and looks as "+ ri" or "- ri", where ri is an integer from 1 to 106, the registration number of the visitor (that is, distinct visitors always have distinct registration numbers).

It is guaranteed that the log is not contradictory, that is, for every visitor the types of any of his two consecutive events are distinct. Before starting the system, and after stopping the room may possibly contain visitors.

Output
Print a single integer — the minimum possible capacity of the reading room.
 */
public class Berland_National_Library {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numberCases = input.nextInt();
		input.nextLine();
		String[] inputArray = new String[numberCases];
		for(int a = 0; a < numberCases; a++){
			inputArray[a] = input.nextLine();
		}
		int[] intInput = new int[numberCases];
		for(int a = 0; a < numberCases; a++){
			intInput[a] = Integer.parseInt(inputArray[a].substring(2, inputArray[a].length())) * (('-' == inputArray[a].charAt(0)) ? -1:1);
			//System.out.println(intInput[a]);
		}
		
		//get maximum added capacity.
		int max = 0; 
		int counter = 0;
		for(int a = 0; a < numberCases; a++){
			if(intInput[a] > 0){
				counter++;
			}
			else{
				counter--;
			}
			if(counter > max){
				max = counter;
			}
		}		
		//Now we need to calculate the minimum number of people before the device is turned on.
		//We need to do this by counting the exits that do not have a corresponding positive before them. Since we only have 100 logs, N^2 is fine.
		int startingPeople = 0;
		for(int a = 0; a < numberCases; a++){
			if(intInput[a] < 0){
				boolean occupantBeforeStart = true;
				for(int b = 0; b < a; b++){
					if(intInput[b] == intInput[a] * -1){
						occupantBeforeStart = false;
					}
				}
				if(occupantBeforeStart == true){
					startingPeople++;
				}
			}
		}
		//Add the numbers
		System.out.println(startingPeople + max);
	}
}
