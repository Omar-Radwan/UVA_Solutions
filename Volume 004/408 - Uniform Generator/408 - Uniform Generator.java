import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            int s = input.nextInt();
            int m = input.nextInt();
            boolean[] seed = new boolean[m + 1];
            int indx = indx = 0;
            for (int i = 1; i <= m; i++) {
                indx = (indx + s) % m;
                seed[indx] = true;
            }

            boolean isGood = true;

            for (int i = 0; i < m; i++) {
                if (seed[i] == false) {
                    isGood = false;
                    break;
                }

            }
            String sStr = Integer.toString(s);
            String mStr = Integer.toString(m);

            for (int i = 0; i < 10 - sStr.length(); i++) {
                System.out.print(" ");
            }
            System.out.print(sStr);
            for (int i = 0; i < 10 - mStr.length(); i++) {
                System.out.print(" ");
            }
            System.out.print(mStr);

            if (isGood)
                System.out.println("    Good Choice");
            else
                System.out.println("    Bad Choice");
            System.out.println();
            if (!input.hasNext())
                break;

        }

    }

}
