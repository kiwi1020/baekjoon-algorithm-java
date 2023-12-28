import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if (o1 < 0) {
                    if (o1 == o2 * -1)
                        return -1;
                    o1 *= -1;
                }

                if (o2 < 0) {
                    if (o1 == o2 * -1)
                        return 1;
                    o2 *= -1;
                }

                if (o1 < o2)
                    return -1;

                else
                    return 1;
            }
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int m = Integer.parseInt(br.readLine());

            if (m == 0) {
                Integer t = priorityQueue.poll();
                if (t == null)
                    bw.write(0 + "\n");
                else
                    bw.write(t + "\n");
            }
            else {
                priorityQueue.offer(m);
            }
        }
        bw.close();
    }
}