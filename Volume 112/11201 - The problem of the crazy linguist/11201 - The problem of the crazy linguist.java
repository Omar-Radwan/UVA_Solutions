import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static double[] beautyTable = { 12.53, 1.42, 4.68, 5.86, 13.68, 0.69, 1.01, 0.70, 6.25, 0.44, 0.00, 4.97, 3.15,
            6.71, 8.68, 2.51, 0.88, 6.87, 7.98, 4.63, 3.93, 0.90, 0.02, 0.22, 0.90, 0.52 };

    static double calcSBC() {
        double sum = 0;

        for (int i = 1; i <= a.length; i++) {
            int cIndx = a[i - 1] - 'a';
            sum += (i * (beautyTable[cIndx]));
        }
        return sum;
    }

    static char[] a;
    static int[] visited;

    static char[][] alph = { { 'a', 'e', 'i', 'o', 'u' }, { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p',
            'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' } };

    static double totalB;
    static int count;

    static void generate(int indx) {
        if (indx == a.length) {
            count++;
            totalB += calcSBC();
            return;
        }

        for (int i = 0; i < alph[(indx + 1) % 2].length; i++) {
            char cand = alph[(indx + 1) % 2][i];
            if (visited[cand - 'a'] < 2) {
                visited[cand - 'a']++;
                a[indx] = cand;
                generate(indx + 1);
                visited[cand - 'a']--;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {

            String s = input.nextLine();

            a = s.toCharArray();

            double sbeauty = calcSBC();

            visited = new int[26];

            totalB = 0;
            count = 0;

            generate(1);

            double avg = totalB / count;
            String ans = "below";
            if (sbeauty > avg || Math.abs(sbeauty - avg) < (1e-9)) {
                ans = "above or equal";
            }

            System.out.println(ans);

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }
    }

}