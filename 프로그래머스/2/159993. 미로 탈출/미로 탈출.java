import java.util.*;
class Solution {
    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        return bfs(map, visited, dx, dy);
    }

    public static int bfs(char[][] map , boolean[][] visit, int[] dx, int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        int startX = 0, startY = 0, leverX = 0, leverY = 0, endX = 0, endY = 0;
        int[][] distance = new int[map.length][map[0].length];
        boolean isLeverOn = false;

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                else if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
                else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }

        queue.add(new int[] {startX, startY});
        distance[startX][startY] = 0;
        visit[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (currentX == leverX && currentY == leverY) {
                isLeverOn = true;
                for (int i = 0; i < visit.length; i++) {
                    for (int j = 0; j < visit[0].length; j++) {
                        visit[i][j] = false;
                    }
                }
                visit[currentX][currentY] = true;
                queue.clear();
            }

            if (currentX == endX && currentY == endY && isLeverOn) {
                return distance[currentX][currentY];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                 if (nextX >= 0 && nextY >=0 && nextX < map.length && nextY < map[0].length &&
                    map[nextX][nextY] != 'X' && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                    distance[nextX][nextY] = distance[currentX][currentY] + 1;
                }
            }
        }

        return -1;
    }
}