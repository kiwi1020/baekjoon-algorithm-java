import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        List<int []>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] c: costs) {
            graph[c[0]].add(new int[]{c[1], c[2]});
            graph[c[1]].add(new int[]{c[0], c[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        int answer = 0;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            if (visited[cur[0]]) continue;

            visited[cur[0]] = true;
            answer += cur[1];

            for (int[] next: graph[cur[0]]) {
                if (!visited[next[0]])
                    pq.offer(next);
            }
        }
        return answer;
    }
}