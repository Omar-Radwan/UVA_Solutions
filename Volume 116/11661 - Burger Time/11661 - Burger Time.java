import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(System.out);

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            if (l == 0)
                break;
            String s = br.readLine();

            int ans = Integer.MAX_VALUE;
            int lastStore = -1;
            char lastChar = 'R';
            for (int i = 0; i < l; i++) {
                char x = s.charAt(i);
                if (x == 'Z') {
                    ans = 0;
                    break;
                } else if (x == 'D' || x == 'R') {
                    if (lastStore != -1) {

                        if (x != lastChar) {
                            int distance = i - lastStore;
                            if (distance < ans)
                                ans = distance;
                        }
                    }
                    lastStore = i;
                    lastChar = x;
                }
            }

            System.out.println(ans);

        }

        out.flush();

    }
}