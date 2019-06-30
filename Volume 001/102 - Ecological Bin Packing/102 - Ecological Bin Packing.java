import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {

            int[] a = new int[9];

            for (int i = 0; i < 9; i++) {
                a[i] = input.nextInt();
            }

            int[][] sums = new int[3][3];

            for (int i = 0; i < 9; i++) {
                for (int j = (i + 3) % 9; j != i; j = (j + 3) % 9) {
                    sums[i % 3][i / 3] += a[j];
                }
            }

            int min = Integer.MAX_VALUE;
            char[] ans = new char[3];

            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    if (k == i)
                        continue;
                    for (int j = 0; j < 3; j++) {
                        if (j == k || j == i)
                            continue;

                        int s = sums[0][i] + sums[1][j] + sums[2][k];

                        if (s < min) {
                            min = s;
                            ans[i] = 'B';
                            ans[j] = 'G';
                            ans[k] = 'C';
                        }

                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                System.out.print(ans[i]);
            }
            System.out.print(" " + min);

            System.out.println();

        }

    }

}
