import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        LinkedList<Integer> list = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int m = 0; m < n; m++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {

                case "push":
                    list.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if (list.isEmpty()) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    else {
                        bw.write(list.pollLast() + "\n");
                        break;
                    }

                case "size":
                    bw.write(list.size() + "\n");
                    break;

                case "empty":
                    if (list.isEmpty()) {
                        bw.write(1 + "\n");
                        break;
                    } else {
                        bw.write(0 + "\n");
                        break;
                    }

                case "top":
                    if (list.isEmpty()) {
                        bw.write(-1 + "\n");
                        break;
                    }

                    bw.write(list.peekLast() + "\n");
                    break;
            }
        }
        bw.close();
    }
}