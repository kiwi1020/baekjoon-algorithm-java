import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();

        for (int i = 'A'; i <= 'Z'; i++) {
            dictionary.put(String.valueOf((char)i), i - 64);
        }

        String w = "";
        for (char c : msg.toCharArray()) {
            String wc = w + c;
            System.out.println(wc);
            if (dictionary.containsKey(wc)) {
                w = wc;
            } else {
                result.add(dictionary.get(w));
                dictionary.put(wc, dictionary.size() + 1);
                w = String.valueOf(c);
            }
        }

        // 마지막 남은 문자열 추가
        if (!w.isEmpty()) {
            result.add(dictionary.get(w));
        }
        return result;
    }
}