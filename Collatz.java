import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
//Solved with Harrison and Chris
//http://codeforces.com/gym/101078/attachments
public class Collatz {

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int cases = in.nextInt();
        for(int q = 0; q < cases; q++) {
            int n = in.nextInt();

            int start1 = n+1;
            int end1 = n+n;
            if(start1 % 2 == 0){
                start1--;
            }
            if(end1%2 == 0){
                end1++;
            }
            int diff = end1-start1;
            int num = diff/2;

            int start2 = (n+2)/3;
            int end2 = n;
            if(start2%2 == 1){
                start2--;
            }
            if(end2%2 == 1){
                end2++;
            }
            int diff2 = end2-start2;
            int num2 = diff2/2;
            System.out.println(num+num2);

        }
    }
    public static void addRemoveSet(int i, HashSet<Integer> set){
        if(set.contains(i)){
            set.remove(i);
        }
        else{
            set.add(i);
        }
    }
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() { this(new InputStreamReader(System.in)); }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        // Slightly different from java.util.Scanner.nextLine(),
        // which returns any remaining characters in current line,
        // if any.
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}