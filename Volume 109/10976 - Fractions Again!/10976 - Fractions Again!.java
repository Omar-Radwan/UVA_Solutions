import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static double calc(int x, int k) {
        return (double) (x - k) / (k * k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {

            int k = Integer.parseInt(s);
            TreeMap<Integer, Integer> ans = new TreeMap<>();

            for (int i = k + 1; i <= 2 * k; i++) {
                double d = (double) (k * i) / (double) (i - k);
                if (Math.abs(Math.round(d) - d) <= 1e-9) {
                    if (!ans.containsKey((int) Math.round(d)) && !ans.containsKey(i)) {
                        ans.put((int) Math.round(d), i);
                    }
                }
            }
            System.out.println(ans.size());
            ArrayList<String> y = new ArrayList();
            for (Map.Entry<Integer, Integer> x : ans.entrySet()) {
                y.add("1/" + k + " = " + "1/" + x.getKey() + " + " + "1/" + x.getValue());
            }

            for (int i = y.size() - 1; i >= 0; i--) {
                System.out.println(y.get(i));
            }

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
