import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        // 큐에 값을 넣고, 각 큐의 총합을 계산
        for (int i : queue1) {
            q1.add((long) i);
            sum1 += i;
        }
        for (int i : queue2) {
            q2.add((long) i);
            sum2 += i;
        }

        int count = 0;
        int maxOperations = 600000;

        while (count <= maxOperations) {
            if (sum1 == sum2) return count;

            if (sum1 > sum2) {

                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
            } else {

                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
            }
            count++;
        }

        return -1;
    }
}