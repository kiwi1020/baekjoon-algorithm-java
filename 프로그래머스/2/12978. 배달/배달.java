import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 그래프 초기화
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int[] r : road) {
            graph[r[0]].add(new int[] {r[1], r[2]});
            graph[r[1]].add(new int[] {r[0], r[2]});
        }

        // 다익스트라 알고리즘
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] > dist[cur[0]]) continue;

            for (int[] next : graph[cur[0]]) {
                int newDist = cur[1] + next[1];
                if (newDist < dist[next[0]]) {
                    dist[next[0]] = newDist;
                    pq.offer(new int[] {next[0], newDist});
                }
            }
        }

        // K 이하 거리 마을 수 카운트
        return (int) Arrays.stream(dist).filter(d -> d <= K).count();
    }
}