import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    static class ForwardSystem {
        String source;
        int x;
        int y;
        String target;

        public ForwardSystem(String source, int x, int y, String target) {
            this.source = source;
            this.x = x;
            this.y = y;
            this.target = target;
        }

        public boolean fallsInTime(int t) {
            return t >= x && t <= x + y ? true : false;
        }

    }

    static class Call {
        String time;
        String target;

        Call(String time, String target) {
            this.time = time;
            this.target = target;
        }
    }

    static int counter;
    static TreeMap<String, Integer> hash;
    static ArrayList<ForwardSystem> forwardSystems;
    static ArrayList<Call> calls;
    static boolean[] visited;

    static void visit(Call x) {

        for (int i = 0; i < forwardSystems.size(); i++) {

            String fwS = forwardSystems.get(i).source;
            String callT = x.target;

            int time = Integer.parseInt(x.time);

            if (fwS.equals(callT) && forwardSystems.get(i).fallsInTime(time) && !visited[hash.get(fwS)]) {

                visited[hash.get(fwS)] = true;

                visit(new Call(x.time, forwardSystems.get(i).target));

                return;
            }

        }
        if (hash.containsKey(x.target)) {

            if (visited[hash.get(x.target)]) {
                System.out.print("9999");
                return;
            }

        }

        System.out.print(x.target);

    }

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        System.out.println("CALL FORWARDING OUTPUT");

        for (int f = 1; f <= t; f++) {

            counter = 0;
            forwardSystems = new ArrayList<>();
            calls = new ArrayList<>();
            hash = new TreeMap<>();
            while (true) {

                String source = input.next();

                if (source.equals("0000")) {
                    break;
                } else {
                    forwardSystems.add(new ForwardSystem(source, input.nextInt(), input.nextInt(), input.next()));
                }

                if (!hash.containsKey(source)) {
                    hash.put(source, counter);
                    counter++;
                }

            }

            while (true) {
                String time = input.next();

                if (time.equals("9000")) {
                    break;
                } else {
                    calls.add(new Call(time, input.next()));
                }
            }
            System.out.println("SYSTEM " + f);
            for (int i = 0; i < calls.size(); i++) {
                visited = new boolean[counter];
                System.out.print("AT " + calls.get(i).time + " CALL TO " + calls.get(i).target + " RINGS ");
                visit(calls.get(i));
                System.out.println();
            }

        }

        System.out.println("END OF OUTPUT");

    }

}
