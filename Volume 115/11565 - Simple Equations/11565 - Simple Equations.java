import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        while (n > 0) {

            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            boolean isFound = false;

            for (int x = (int) -Math.sqrt(c - 2); x * x <= c - 1 && !isFound; x++) {
                for (int y = (int) -Math.sqrt(c - x * x - 1); y * y <= c - x * x && !isFound; y++) {
                    for (int z = (int) -Math.sqrt(c - x * x - y * y); z * z <= c - x * x - y * y + 1; z++) {
                        if (x != y && y != z && z != x) {
                            if (x + y + z == a) {
                                if (x * y * z == b) {
                                    if (x * x + y * y + z * z == c) {
                                        System.out.println(x + " " + y + " " + z);
                                        isFound = true;
                                        break;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }

            if (!isFound) {
                System.out.println("No solution.");
            }

            n--;
        }

    }

}
