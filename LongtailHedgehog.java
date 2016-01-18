import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class LongtailHedgehog {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numPoints = input.nextInt();
		int numSegments = input.nextInt();
		HashMap<Integer, HashSet<Integer>> edges = new HashMap<Integer, HashSet<Integer>>();
		for(int a = 0; a <= numPoints; a++){
			edges.put(a, new HashSet<Integer>());
		}
		for(int a = 0; a < numSegments; a++){
			int start = input.nextInt()-1;
			int end = input.nextInt()-1;
			edges.get(start).add(end);
			edges.get(end).add(start);
		}
		long[] dynamicProgramming = new long[numPoints];
		long[] possibilities = new long[numPoints];
		for(int a = 0; a < numPoints; a++){
			if(a == 0){
				dynamicProgramming[a] = 1;
			}
			else{
				long max = 1;
				for(Integer b: edges.get(a)){
						if(b < a){
							if(dynamicProgramming[b]+1 > max){
								max = dynamicProgramming[b]+1;
							}
						}
				}
				dynamicProgramming[a] = max;				
			}
			possibilities[a] = dynamicProgramming[a] * edges.get(a).size();
		}
		long max = -1;
		for(int a = 0; a < possibilities.length; a++){
			if(max < possibilities[a]){
				max = possibilities[a];
			}
		}
		System.out.println(max);
	}	
}
