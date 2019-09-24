import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        while (true) {
            String s = input.nextLine();
            if (s == null || s.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(s);

            int T, R, H;

            T = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int tprice[] = new int[T];
            int rprice[] = new int[R];
            int hprice[] = new int[H];

            boolean trAdj[][] = new boolean[T][R];
            boolean rhAdj[][] = new boolean[R][H];
            boolean htAdj[][] = new boolean[H][T];

            for (int i = 0; i < T; i++) {
                tprice[i] = input.nextInt();
                for (int j = 0; j < R; j++) {
                    int x = input.nextInt();
                    trAdj[i][j] = x == 1 ? true : false;
                }
            }

            for (int i = 0; i < R; i++) {
                rprice[i] = input.nextInt();
                for (int j = 0; j < H; j++) {
                    int x = input.nextInt();
                    rhAdj[i][j] = x == 1 ? true : false;
                }
            }

            for (int i = 0; i < H; i++) {
                hprice[i] = input.nextInt();
                for (int j = 0; j < T; j++) {
                    int x = input.nextInt();
                    htAdj[i][j] = x == 1 ? true : false;
                }
            }
            int min = Integer.MAX_VALUE;
            Triple best = new Triple(-1, -1, -1);

            for (int t = 0; t < T; t++) {
                for (int r = 0; r < R; r++) {
                    for (int h = 0; h < H; h++) {
                        if ((trAdj[t][r] || rhAdj[r][h] || htAdj[h][t]))
                            continue;
                        int price = tprice[t] + rprice[r] + hprice[h];
                        if (price < min) {
                            min = price;
                            best = new Triple(t, r, h);
                        }
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                out.println("Don't get married!");
            } else {
                out.println(best.t + " " + best.r + " " + best.h + ": " + min);
            }

            out.flush();
        }

    }

    static class Triple {
        int t, r, h;

        Triple(int t, int r, int h) {
            this.t = t;
            this.r = r;
            this.h = h;
        }
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
