import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Main {

    static PrintWriter out = new PrintWriter(System.out);

    static final char[] vowels = "aeiouAEIOU".toCharArray();

    static boolean isc(int i) {
        return i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z';
    }

    static boolean isV(int i) {
        for (char c : vowels)
            if (c == i)
                return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        int firstLetter = -1;
        while (true) {
            int i = br.read();
            char c = (char) i;

            if (i == -1) {
                break;
            }

            if (isc(c)) {
                if (firstLetter == -1) {
                    if (isV(c)) {
                        s.append(c);
                    }
                    firstLetter = c;
                } else {
                    s.append(c);
                }
            } else {
                if (firstLetter != -1) {
                    if (!isV(firstLetter)) {
                        s.append((char) firstLetter);
                    }
                    s.append("ay");
                    firstLetter = -1;
                }
                s.append(c);
            }

        }
        out.print(s);

        out.flush();
    }

}