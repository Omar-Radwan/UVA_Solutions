import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;

            int a[][] = new int[n][n];
            int[] rowSum = new int[n];
            int[] colSum = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = input.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rowSum[i] += a[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    colSum[i] += a[j][i];
                }
            }

            int[] indexToChange = { -1, -1 };
            boolean isCorrupt = false;

            for (int i = 0; i < n; i++) {
                if (colSum[i] % 2 != 0) {
                    if (indexToChange[1] == -1) {
                        indexToChange[1] = i + 1;
                    } else {
                        isCorrupt = true;
                        break;
                    }

                }

                if (rowSum[i] % 2 != 0) {
                    if (indexToChange[0] == -1) {
                        indexToChange[0] = i + 1;
                    } else {
                        isCorrupt = true;
                        break;
                    }

                }

            }

            if (isCorrupt) {
                System.out.println("Corrupt");
            } else if (indexToChange[0] == -1 && indexToChange[1] == -1) {
                System.out.println("OK");
            } else {
                System.out.println("Change bit (" + indexToChange[0] + "," + indexToChange[1] + ")");
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
