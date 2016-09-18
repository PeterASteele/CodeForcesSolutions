import java.util.Arrays;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/230/B
public class TPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		boolean[] arr = sieve(5000000);
		StringBuilder output = new StringBuilder();
		for(int a = 0; a < n; a++){
			long x = input.nextLong();
			double squareRoot = Math.sqrt(x);
			long y = Math.round(squareRoot);
	
			if(y*y == x && arr[(int)y]){
				output.append("YES\n");
			}
			else{
				output.append("NO\n");
			}
		}
		System.out.print(output);
	}

    public static boolean[] sieve(int N)
    {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= N; i++)
        {
            if (!isPrime[i])
                continue;
            for (int multiples = i*i; multiples <= N; multiples += i)
                isPrime[multiples] = false;
        }
        return isPrime;
    }
}