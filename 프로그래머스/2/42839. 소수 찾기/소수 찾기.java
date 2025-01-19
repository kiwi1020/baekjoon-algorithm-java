import java.util.*;
class Solution {
    public int solution(String numbers) {
        char[] number = new char[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
        String current = "";
        Set<Integer> set = new HashSet<>();
        
        number = numbers.toCharArray();
        
        return dfs(number, visited, current, set);
    }
    
    public int dfs(char[] number, boolean[] visited, String current, Set<Integer> set) {
        int answer = 0;
        
        if (!(current.length() == 0))
            set.add(Integer.parseInt(current));
            
        for (int i = 0; i < number.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                dfs(number, visited, current.concat(String.valueOf(number[i])), set);
                visited[i] = false;
            }
        }
        
        for (int i : set)
            if (isPrime(i))
                answer++;
        
        return answer;
    }
    
    
    public boolean isPrime(int n) {
                                      
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}