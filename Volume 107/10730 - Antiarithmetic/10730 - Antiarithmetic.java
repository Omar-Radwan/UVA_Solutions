import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken(":"));
            if (n == 0)
                break;

            int[] a = new int[n];

            TreeMap<Integer, Integer> aToIndx = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken(" :"));
                aToIndx.put(a[i], i);
            }

            String ans = "yes";

            for (int i = 0; i < n && ans.equals("yes"); i++) {
                for (int j = i + 1; j < n; j++) {
                    int x = a[i] + a[j];
                    if (x % 2 == 0) {
                        x /= 2;
                        if (aToIndx.containsKey(x)) {
                            int indx = aToIndx.get(x);
                            if (indx > i && indx < j) {
                                ans = "no";
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(ans);

        }
    }
}