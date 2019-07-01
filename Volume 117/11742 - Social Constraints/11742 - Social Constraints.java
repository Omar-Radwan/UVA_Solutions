import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static int fact(int n) {
        if (n == 0)
            return 1;
        return n * fact(n - 1);
    }

    static ArrayList<String> permutations;
    static boolean[] visited;

    static void perm(int n, String temp) {
        int start = n;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                start = i;
                break;
            }
        }

        if (start == n) {
            permutations.add(temp);
            return;
        }
        String temp1 = "";
        for (int i = start; i < n; i++) {
            if (visited[i] == false) {
                temp1 = temp + i;
                visited[i] = true;
                perm(n, temp1);
                visited[i] = false;
            }

        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            int n = input.nextInt();

            int m = input.nextInt();
            permutations = new ArrayList<>();
            visited = new boolean[n];

            if (n == 0 && m == 0)
                break;

            perm(n, "");

            int ways = fact(n);

            boolean[] visitedPermutations = new boolean[permutations.size()];

            for (int i = 0; i < m; i++) {

                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();

                for (int j = 0; j < permutations.size(); j++) {

                    if (!visitedPermutations[j]) {

                        int aPos = 0;
                        int bPos = 0;

                        for (int k = 0; k < permutations.get(j).length(); k++) {
                            if (permutations.get(j).charAt(k) == a + 48) {
                                aPos = k;
                            }
                            if (permutations.get(j).charAt(k) == b + 48) {
                                bPos = k;
                            }

                        }
                        if (c < 0 && Math.abs(aPos - bPos) < Math.abs(c)) {
                            ways -= 1;
                            visitedPermutations[j] = true;
                        } else if (c > 0 && Math.abs(aPos - bPos) > c) {
                            ways -= 1;
                            visitedPermutations[j] = true;
                        }
                    }
                }

            }

            System.out.println(ways);

        }
    }

}