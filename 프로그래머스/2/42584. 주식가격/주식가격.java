import java.util.*;

class Solution {
    public List<Integer> solution(int[] prices) {
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            boolean findHighPrice = false;
            for (int j = i; j < prices.length; j++) {
                if (currentPrice > prices[j]) {
                    answers.add(j - i);
                    findHighPrice = true;
                    break;
                }
            }
            if (!findHighPrice) {
                answers.add(prices.length - i - 1);
            }
        }
        return answers;
    }
}