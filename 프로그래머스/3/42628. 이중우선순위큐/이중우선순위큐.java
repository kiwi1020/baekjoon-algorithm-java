import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
      
        for (String s: operations) {
            if (s.startsWith("I")) {
                int n = Integer.parseInt(s.substring(2));
                minHeap.offer(n);
                maxHeap.offer(n);
            } else {
                if (s.charAt(2) == '-') {
                    maxHeap.remove(minHeap.poll());
                } else {
                    minHeap.remove(maxHeap.poll());
                }
            }
        }
        answer[0] = maxHeap.peek() != null ? maxHeap.peek() : 0;
        answer[1] = minHeap.peek() != null ? minHeap.peek() : 0;
        return answer;
    }
}