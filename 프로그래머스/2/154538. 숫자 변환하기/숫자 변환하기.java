import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }

    public static int bfs(int x, int y, int n) {
        if (x == y) return 0;

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(new int[] {x, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == y) return current[1];

            if (current[0] + n <= y && !visited.contains(current[0] + n)) {
                queue.offer(new int[] {current[0] + n, current[1] + 1});
                visited.add(current[0] + n);
            };

            if (current[0] * 2 <= y && !visited.contains(current[0] * 2)) {
                queue.offer(new int[] {current[0] * 2, current[1] + 1});
                visited.add(current[0] * 2);
            }

            if (current[0] * 3 <= y && !visited.contains(current[0] * 3)) {
                queue.offer(new int[] {current[0] * 3, current[1] + 1});
                visited.add(current[0] * 3);
            }
        }
        return -1;
    }
}