import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {

            int n = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();

            int sum = 0;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[j] <= a[i]) {
                        sum++;
                    }
                }
            }

            System.out.println(sum);

        }

    }

}
