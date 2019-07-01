import java.io.IOException;
import java.util.Scanner;

class Main {

    static void generate(String rule, String s, int indx, String ans) {
        if (indx >= rule.length()) {
            System.out.println(ans);
            return;
        }
        if (rule.charAt(indx) == '#') {
            generate(rule, s, indx + 1, ans + s);
        } else {
            for (int i = '0'; i <= '9'; i++) {
                generate(rule, s, indx + 1, ans + (char) i);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {

            int n = input.nextInt();
            String a[] = new String[n];

            for (int i = 0; i < n; i++)
                a[i] = input.next();

            int m = input.nextInt();
            String[] rules = new String[m];

            for (int i = 0; i < m; i++) {
                rules[i] = input.next();
            }
            System.out.println("--");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    generate(rules[i], a[j], 0, "");

                }
            }

        }

    }

}
