import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int answer = 0;

        for (int i : scoville) pq.add(i);

        while (!pq.isEmpty()) {
            int first = pq.poll();
            int second = pq.poll();

            if (first >= K) break;

            answer++;
            pq.offer(first + (second * 2));

            if (pq.size() == 1) {
                if (pq.peek() < K) return -1;
                else return answer;
            }
        }
        return answer;
    }
}