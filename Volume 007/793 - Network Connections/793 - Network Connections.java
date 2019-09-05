import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    
    static int p[];
    static int r[];

    static void initialize(int n) {
        p = new int[n];
        r = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i;

    }

    static void connect(int x, int y) {
        if (!query(x, y)) {
            int i = findset(x);
            int j = findset(y);
            if (r[i] > r[j]) {
                p[j] = i;
            } else {
                p[i] = j;
                if (r[i] == r[j]) {
                    r[j]++;
                }
            }
        }
    }

    static boolean query(int x, int y) { return findset(x) == findset(y); }

    static int findset(int x) { return p[x] = p[x] == x ? x : findset(p[x]); }

    public static void main(String[] args) throws IOException {
        
        int t = input.nextInt();
        input.nextLine();

        while (t-- > 0) {
        
            int n = input.nextInt();
            int good = 0, bad = 0;
            
            initialize(n);

            while (true) {
                
                String s = input.nextLine();
                if (s == null || s.isEmpty())
                    break;
                
                else {
                    StringTokenizer st = new StringTokenizer(s);
                    String type = st.nextToken();
                    
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    
                    if (type.equals("c")) {
                        connect(x - 1, y - 1);
                    } else {
                        if (query(x - 1, y - 1)) {
                            good++;
                        } else
                            bad++;
                    }
                }

            }
            out.println(good + "," + bad);
            if (t > 0)
                out.println();
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