import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;

        for (int i = 0; i < enemy.length; i++) {
            int value = enemy[i];
            n -= value;
            maxHeap.offer(value);

            if (n < 0) {
                if (k <= 0) break;
                int maxValue = maxHeap.poll();
                k--;
                n += maxValue; 
            }
            answer++;
        }
        return answer;
    }
}