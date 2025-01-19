import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { 
                dfs(n, computers, visited, i); 
                answer++; 
        }
    }
        return answer;
    }
    
    public void dfs(int n, int[][] computers, boolean[] visited, int current) {
        visited[current] = true;
        
        for (int i = 0; i < n; i++) {
            if (computers[current][i] == 1 && !visited[i])  
                dfs(n, computers, visited, i);
        }
    }
}