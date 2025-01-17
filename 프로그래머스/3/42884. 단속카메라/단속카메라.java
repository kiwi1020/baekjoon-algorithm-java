import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] i : routes) pq.offer(i);

        int m = pq.poll()[1];
        int answer = 1;

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            if (m < cur[0]) {
                m = cur[1];
                answer++;
            }
        }
        return answer;
    }
}