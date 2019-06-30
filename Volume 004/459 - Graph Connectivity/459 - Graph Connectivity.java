import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> g;

    static void dfs(int s) {
        visited[s] = true;
        for (int i = 0; i < g.get(s).size(); i++) {
            if (!visited[g.get(s).get(i)]) {
                dfs(g.get(s).get(i));
            }
        }
    }

    static int firstUnvisited() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        input.nextLine();
        input.nextLine();

        while (t > 0) {

            char maxChar = input.nextLine().charAt(0);

            int max = (int) maxChar - 65;

            g = new ArrayList<>();
            visited = new boolean[max + 1];

            for (int i = 0; i <= max; i++) {
                g.add(new ArrayList<Integer>());
            }

            while (input.hasNextLine()) {
                String edge = input.nextLine();
                if (edge.equals("")) {
                    break;
                }
                g.get(edge.charAt(0) - 65).add(edge.charAt(1) - 65);
                g.get(edge.charAt(1) - 65).add(edge.charAt(0) - 65);

            }

            int count = 0;

            while (true) {
                if (firstUnvisited() != -1) {
                    dfs(firstUnvisited());
                    count++;
                } else {
                    break;
                }
            }

            System.out.println(count);

            if (t > 1) {
                System.out.println();
            }

            t--;

        }

    }

}
