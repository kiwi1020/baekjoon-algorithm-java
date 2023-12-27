import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Long n = Long.parseLong(br.readLine());

        for (int i = 0; i < n; i++) {
            String firstLine = br.readLine();
            String secondLine = br.readLine();

            st = new StringTokenizer(firstLine);
            int documentN = Integer.parseInt(st.nextToken());
            int importance = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(secondLine);

            LinkedList<Integer[]> list = new LinkedList<>();

            for (int m = 0; m < documentN; m++) {
                list.add(new Integer[]{m, Integer.parseInt(st.nextToken())});
            }

            int result = 0;

            Loop:
            while (!list.isEmpty()) {
                for (int m = 0; m < list.size(); m++) {
                    if (list.peek()[1] < list.get(m)[1]) {
                        list.offer(list.peek());
                        list.poll();
                        break;
                    } else if (m == list.size() - 1) {
                        if (list.peek()[0] == importance) {
                            result++;
                            break Loop;
                        }
                        list.poll();
                        result++;
                    }
                }

            }
            bw.write(String.valueOf(result) + "\n");
        }
        bw.close();
    }
}