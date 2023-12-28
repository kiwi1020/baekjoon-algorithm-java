import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

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