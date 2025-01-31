import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        char[] c = new char[] {'A', 'E', 'I', 'O', 'U'};
        boolean[] visited = new boolean[5];

        Arrays.fill(visited, false);
        dfs(list, c, "", 0);
        answer = list.indexOf(word) + 1;

        return answer;
    }
    
    public void dfs(List<String> list, char[] c, String s, int depth) {
        if (depth > 5) return;

        if (!s.isEmpty()) {
            list.add(s);
        }

        for (int i = 0; i < c.length; i++) {
            dfs(list, c, s + c[i], depth + 1);
        }
    }
    
}