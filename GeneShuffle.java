import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
//Solved with Harrison and Chris
//http://codeforces.com/gym/101078/attachments
public class GeneShuffle {

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int cases = in.nextInt();
        for(int q = 0; q < cases; q++) {

            int n = in.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            HashSet<Integer> set = new HashSet<Integer>();
            for (int a = 0; a < n; a++) {
                arr1[a] = in.nextInt();
            }
            for (int a = 0; a < n; a++) {
                arr2[a] = in.nextInt();
            }
            int start = 1;
            int end = 1;
            StringBuilder out = new StringBuilder();
            for (int a = 0; a < n; a++) {
                addRemoveSet(arr1[a], set);
                addRemoveSet(arr2[a], set);
                if (set.size() == 0) {
                    out.append(start + "-" + end + " ");
                    start = end + 1;
                    end = start;
                } else {
                    end++;
                }
            }
            System.out.println(out);
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