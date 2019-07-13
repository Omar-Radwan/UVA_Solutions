import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        TreeMap<Character, Character> map = new TreeMap<>();
        map.put('0', '0');
        map.put('1', '1');
        int c = 'A';
        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < 3; j++) {
                map.put((char) c++, (char) (i + '0'));
            }
            if (i == 7 || i == 9)
                map.put((char) c++, (char) (i + '0'));
        }

        while (true) {
            char s[] = input.nextLine().toCharArray();
            for (int i = 0; i < s.length; i++) {
                Character x = map.get(s[i]);
                s[i] = x != null ? x : s[i];
            }
            out.println(new String(s));

            if (!input.hasNext())
                break;

        }
        out.flush();

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

        boolean hasNext() throws IOException {
            return br.ready();
        }
    }

}