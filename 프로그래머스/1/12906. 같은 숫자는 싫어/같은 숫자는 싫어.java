import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<>();
        queue.offer(-1);
        for (int i : arr) {
            int j = queue.poll();
        
            if (j != i) 
                list.add(i);
            
            queue.offer(i);
        }
        
        return list;
    }
}