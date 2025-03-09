import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>(numbers.length);

        for (int i : numbers) {
            list.add(String.valueOf(i));
        }

        list.sort((a, b) -> (b + a).compareTo(a + b));

        String answer = "";

        for (String s : list)
            answer = answer.concat(s);
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}