import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static boolean[][] states;
    static int ca, cb, n;
    static ArrayList<String> solution;
    static boolean foundSol;

    static void solve(int a, int b, int step) {

        if (states[a][b] || foundSol)
            return;

        if (a == n || b == n) {
            foundSol = true;
            for (int i = 0; i < step; i++) {
                System.out.println(solution.get(i));
            }
            System.out.println("success");
            return;
        }

        states[a][b] = true;

        solution.add("fill A");
        solve(ca, b, step + 1);
        solution.remove(step);

        solution.add("fill B");
        solve(a, cb, step + 1);
        solution.remove(step);

        solution.add("empty A");
        solve(0, b, step + 1);
        solution.remove(step);

        solution.add("empty B");
        solve(a, 0, step + 1);
        solution.remove(step);

        int diff = Math.min(a, cb - b);
        solution.add("pour A B");
        solve(a - diff, b + diff, step + 1);
        solution.remove(step);

        diff = Math.min(b, ca - a);
        solution.add("pour B A");
        solve(a + diff, b - diff, step + 1);
        solution.remove(step);

        states[a][b] = false;
    }

    public static void main(String args[]) throws IOException {

        while (input.hasNext()) {

            ca = input.nextInt();
            cb = input.nextInt();
            n = input.nextInt();

            states = new boolean[1004][1004];
            solution = new ArrayList<>();
            foundSol = false;

            solve(0, 0, 0);

        }

    }

}