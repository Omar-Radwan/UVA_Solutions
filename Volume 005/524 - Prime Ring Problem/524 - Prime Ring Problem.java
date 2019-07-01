import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n;
    static ArrayList<String> patterns;
    static boolean[] visited;

    static boolean primeCheck(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void generatePatterns(int parent, String s, int length) {

        if (length == n && primeCheck(1 + parent))
            System.out.println(s);
        s += " ";
        for (int i = 2; i <= n; i++) {
            if (!visited[i] && primeCheck(i + parent)) {
                visited[i] = true;
                generatePatterns(i, s + i, length + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        while (true) {
            String s = br.readLine();
            if (s == null || s.equals(""))
                break;
            if (i > 1)
                System.out.println();
            patterns = new ArrayList<>();
            StringTokenizer input = new StringTokenizer(s);
            n = Integer.parseInt(input.nextToken());
            visited = new boolean[n + 1];
            System.out.println("Case " + i + ":");
            generatePatterns(1, "1", 1);
            i++;
        }
    }

}
