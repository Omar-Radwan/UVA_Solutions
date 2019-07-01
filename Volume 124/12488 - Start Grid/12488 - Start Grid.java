import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        while (input.hasNext()) {

            int n = input.nextInt();

            LinkedList<Integer> s = new LinkedList<>();
            LinkedList<Integer> e = new LinkedList<>();

            for (int i = 0; i < n; i++)
                s.add(input.nextInt());
            for (int i = 0; i < n; i++)
                e.add(input.nextInt());
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (e.get(i) == s.get(j)) {
                        if (i < j) {
                            s.remove(j);
                            s.add(i, e.get(i));
                            count += (j - i);
                            break;
                        }
                    }
                }
            }

            System.out.println(count);

        }
    }

}
