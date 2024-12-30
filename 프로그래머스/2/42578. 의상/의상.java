import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.putIfAbsent(clothes[i][1], 0);
            map.computeIfPresent(clothes[i][1], (key, value) -> value + 1 );
        }
        int answer = 1;
        for (String s : map.keySet()){
            answer *= (map.get(s) + 1);
        }
        return answer - 1;
    }
}