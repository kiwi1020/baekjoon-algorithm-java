import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        int n = 0, m = 0;

        for (Character c : s.toCharArray()) queue.offer(c);

        while (!queue.isEmpty()) {
            if (queue.poll() == '(')
                n++;
            else
                m++;
            if (m > n)
                return false;
        }
        
        if (n != m)
            return false;
        
        return true;
    }
}