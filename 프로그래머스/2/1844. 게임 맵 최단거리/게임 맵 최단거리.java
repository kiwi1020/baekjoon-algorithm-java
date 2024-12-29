import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        boolean[][] visit = new boolean[maps.length][ maps[0].length];

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        return bfs(maps, visit, dx, dy);
    }

    public int bfs(int[][] maps, boolean[][] visit, int[] dx, int[] dy) {
        int startX = 0;
        int startY = 0;
        int[][] distance = new int[maps.length][maps[0].length];
        
        distance[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visit[startX][startY] = true;
        
        if (startX == maps.length - 1 && startY == maps[0].length - 1) {
                return distance[startX][startY];
            }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            startX = current[0];
            startY = current[1];

            if (startX == maps.length - 1 && startY == maps[0].length - 1) {
                return distance[startX][startY];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = startX + dx[i];
                int nextY = startY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < maps.length && nextY < maps[0].length
                        && !visit[nextX][nextY] && maps[nextX][nextY] == 1) {
                    visit[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    distance[nextX][nextY] = distance[startX][startY] + 1;
                }
            }
        }
        return -1;
    }
}