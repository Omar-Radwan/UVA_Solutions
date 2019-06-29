import java.io.IOException;
import java.util.Scanner;

class Main {

    static int[] row;
    static int[] rowTemp;
    static int min;
    static boolean isTaken[];

    static boolean isGood(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (i == j)
                    continue;
                if (rowTemp[i] == rowTemp[j])
                    return false;
                if (Math.abs(i - j) == Math.abs(rowTemp[i] - rowTemp[j]))
                    return false;
            }
        }
        return true;
    }

    static void tryAllPoss(int moves, int colNumber) {
        if (!isGood(colNumber - 1))
            return;

        if (colNumber == 9) {

            for (int i = 0; i < 8; i++) {
                if (row[i] == rowTemp[i])
                    moves--;
            }

            if (moves < min)
                min = moves;

            return;
        }

        for (int i = 1; i <= 8; i++) {
            if (!isTaken[i - 1]) {
                rowTemp[colNumber - 1] = i;
                isTaken[i - 1] = true;
                tryAllPoss(moves + 1, colNumber + 1);
                isTaken[i - 1] = false;
            }
        }

    }

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);

        for (int j = 1; input.hasNext(); j++) {
            min = Integer.MAX_VALUE;
            isTaken = new boolean[8];
            row = new int[8];
            rowTemp = new int[8];

            for (int i = 0; i < 8; i++) {
                row[i] = input.nextInt();
            }

            tryAllPoss(0, 1);

            System.out.println("Case " + j + ": " + min);
        }

    }

}
