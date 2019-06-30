import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static boolean isSolution(int a, int b) {

        boolean[] numbers = new boolean[10];

        String aStr = Integer.toString(a);
        String bStr = Integer.toString(b);

        for (int i = 0; i < aStr.length(); i++) {
            int indx = aStr.charAt(i) - 48;
            if (numbers[indx])
                return false;

            else
                numbers[indx] = true;
        }
        for (int i = 0; i < bStr.length(); i++) {
            int indx = bStr.charAt(i) - 48;
            if (numbers[indx])
                return false;

            else
                numbers[indx] = true;
        }

        if (aStr.length() == 5 && bStr.length() == 5
                || (bStr.length() == 4) && aStr.length() == 5 && numbers[0] == false) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            ArrayList<String> answers = new ArrayList<>();
            int n = input.nextInt();

            if (n == 0) {
                break;
            }
            int max = 98765 / n;

            for (int fghij = 1234; fghij <= max; fghij++) {

                int abcde = n * fghij;

                if (isSolution(abcde, fghij)) {
                    String a = Integer.toString(abcde);
                    String b = Integer.toString(fghij);

                    if (b.length() == 4) {
                        b = "0" + b;
                    }
                    answers.add(a + " / " + b + " = " + Integer.toString(n));
                }

            }

            if (!answers.isEmpty()) {
                for (int i = 0; i < answers.size(); i++) {
                    System.out.println(answers.get(i));
                }
            } else {
                System.out.println("There are no solutions for " + Integer.toString(n) + ".");
            }

            if (!input.hasNext("0")) {
                System.out.println();
            }

        }

    }

}
