import java.util.*;
class Solution {
    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(dungeons, visited, k, 0);
    }

    private static int dfs(int[][] dungeons, boolean[] visited, int k, int count) {
        int maxCount = count;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                maxCount = Math.max(maxCount, dfs(dungeons, visited, k - dungeons[i][1], count + 1));
                visited[i] = false; 
            }
        }

        return maxCount;
    }
}