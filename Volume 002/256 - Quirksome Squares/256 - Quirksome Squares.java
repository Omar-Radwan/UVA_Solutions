import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] zeros = new String[8];
        Arrays.fill(zeros, "");

        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < i; j++) {
                zeros[i] += "0";
            }
        }
        ArrayList<String>[] answers = new ArrayList[5];

        for (int j = 1; j < 5; j++) {
            answers[j] = new ArrayList<>();
            int n = j * 2;
            int max = (int) Math.pow(10, n);

            for (int i = 0; i < max; i++) {

                String number = Integer.toString(i);
                number = zeros[n - number.length()] + number;

                int x1 = Integer.parseInt(number.substring(0, n / 2));
                int x2 = Integer.parseInt(number.substring(n / 2));
                if ((x1 + x2) * (x1 + x2) == i) {
                    answers[j].add(number);

                } else if ((x1 + x2) * (x1 + x2) > i) {
                    i = i / (int) Math.pow(10, n / 2 - 1);
                    i = (i + 1) * (int) Math.pow(10, n / 2 - 1);
                }

            }

        }

        while (input.hasNextLine()) {
            int x = input.nextInt();
            for (int i = 0; i < answers[x / 2].size(); i++) {
                System.out.println(answers[x / 2].get(i));
            }
        }

    }

}
