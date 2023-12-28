import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> targetList = new ArrayList<>();
        Stack<Integer> storage = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int i = 1;

        for (int m = 0; m < n; m++) {
            targetList.add(Integer.parseInt(br.readLine()));
        }

        for (int m = 0; m < targetList.size(); m++) {
            if (i <= targetList.get(m)) {
                while (i < targetList.get(m)) {
                    storage.push(i++);
                    sb.append("+" + "\n");
                }
                sb.append("+" + "\n" + "-" + "\n");
                i++;
            }
            else {
                if (storage.peek().equals(targetList.get(m))) {
                    storage.pop();
                    sb.append("-" + "\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}