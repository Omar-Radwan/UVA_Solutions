import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        int t = input.nextInt();

        for (int j = 1; j <= t; j++) {

            int n = input.nextInt();
            int k = input.nextInt();

            String s = input.next();

            TreeMap<Character, Integer> met = new TreeMap<>();

            int count = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (met.containsKey(c)) {
                    int diff = i - met.get(c);
                    if (diff <= k) {
                        count++;
                    }
                }
                met.put(c, i);
            }

            System.out.println("Case " + j + ": " + count);

        }
    }

}
