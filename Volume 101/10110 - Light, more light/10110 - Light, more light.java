import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            long n = input.nextLong();
            if (n == 0)
                break;

            long x = (long) Math.round((Math.sqrt(n)));

            if (x * x == n)
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }

}
