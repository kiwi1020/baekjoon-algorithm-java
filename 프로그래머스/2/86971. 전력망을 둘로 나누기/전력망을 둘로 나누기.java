import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] wire: wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        System.out.println(Arrays.toString(graph));

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                boolean[] visit = new boolean[graph.length + 1];
                Arrays.fill(visit, false);;
                visit[i] = true;
                visit[graph[i].get(j)] = true;
                int u = dfs(graph, i, visit);
                int v = dfs(graph, graph[i].get(j), visit);

                min = Math.min(min, Math.abs(u - v));
            }
        }
        return min;
    }

    public static int dfs(List<Integer>[] graph, int startNode, boolean[] visit) {
        int sum = 0;
        visit[startNode] = true;
        sum++;
        for (int i : graph[startNode]) {
            if (visit[i] == false) {
                sum += dfs(graph, i, visit);
            }
        }
        return sum;
    }
}