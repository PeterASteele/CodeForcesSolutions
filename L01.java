import java.util.*;
//Solved with Harrison and Chris
//http://codeforces.com/gym/101090/attachments
public class L01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] arr = in.next().toCharArray();

        double ans = 0;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] == '1' && arr[j] == '0') {
                ans += Math.sqrt(j - i);
                i++; j--;
            } else {
                if (arr[i] == '0') i++;
                if (arr[j] == '1') j--;
            }
        }

        System.out.println(ans);
    }
}