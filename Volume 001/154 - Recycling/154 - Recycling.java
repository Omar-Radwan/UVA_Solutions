import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {
        boolean fullBreak = false;
        while (true) {

            ArrayList<char[]> data = new ArrayList<>();

            while (true) {
                String s = input.nextLine();

                if (s.charAt(0) == 'e') {
                    break;
                }
                if (s.charAt(0) == '#') {
                    fullBreak = true;
                    break;
                }

                data.add(new char[26]);

                StringTokenizer st = new StringTokenizer(s, ", /");

                while (st.hasMoreTokens()) {
                    char x = st.nextToken().charAt(0);
                    char y = st.nextToken().charAt(0);

                    int indx = data.size() - 1;
                    data.get(indx)[x - 'a'] = y;

                }

            }
            if (fullBreak)
                break;
            int min = Integer.MAX_VALUE;
            int minIndx = -1;
            int n = data.size();
            char[] chars = "roygb".toCharArray();

            for (int selected = 0; selected < n; selected++) {
                int sum = 0;
                for (int comp = 0; comp < n; comp++) {
                    for (char c : chars) {
                        if (data.get(selected)[c - 'a'] != data.get(comp)[c - 'a']) {
                            sum++;
                        }

                    }
                }
                if (sum < min) {
                    min = sum;
                    minIndx = selected;
                }

            }

            out.println(minIndx + 1);

        }

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) { st = new StringTokenizer(br.readLine()); }
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

        long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

        double nextDouble() throws NumberFormatException, IOException { return Double.parseDouble(next()); }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }

        boolean hasNext() throws IOException { return br.ready(); }
    }

}