import java.math.BigInteger;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            BigInteger a = new BigInteger(input.nextLine());
            BigInteger b = new BigInteger(input.nextLine());
            System.out.println(a.multiply(b));
        }
    }

}
