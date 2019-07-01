import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int t = input.nextInt();

        for (int w = 0; w < t; w++) {

            int m = input.nextInt();

            ArrayList<int[]> c = new ArrayList<>();

            while (true) {

                int[] in = { input.nextInt(), input.nextInt() };

                if (in[0] == 0 && in[1] == 0) {
                    break;
                }

                if (in[0] < m && in[1] > 0) {

                    if (in[1] > m) {
                        in[1] = m;
                    }

                    if (in[0] < 0) {
                        in[0] = 0;
                    }

                    c.add(in);
                }

            }

            if (c.isEmpty()) {
                System.out.println(0);

            }

            else {

                ArrayList<int[]> sol = new ArrayList<>();
                sol.add(new int[] { -1, 0 });

                int j = 1;

                boolean isFound = false;

                while (true) {

                    sol.add(new int[] { 0, 0 });

                    for (int i = 0; i < c.size(); i++) {

                        if (c.get(i)[0] > sol.get(j - 1)[0] && c.get(i)[0] <= sol.get(j - 1)[1]
                                && c.get(i)[1] > sol.get(j)[1]) {
                            sol.set(j, c.get(i));

                        }
                    }
                    if (sol.get(j)[0] == 0 && sol.get(j)[1] == 0) {
                        break;
                    }
                    if (sol.get(j)[1] >= m) {
                        isFound = true;
                        break;
                    }
                    j++;
                }

                if (isFound) {
                    System.out.println(j);
                    for (int i = 1; i <= j; i++) {

                        System.out.println(sol.get(i)[0] + " " + sol.get(i)[1]);
                    }
                } else {
                    System.out.println(0);
                }

                System.out.println();

            }

        }
    }
}