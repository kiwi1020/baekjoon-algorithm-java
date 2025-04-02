import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> answers = new ArrayList<>();
        int left = 0, right = 0, total = sequence[0];

        while (right < sequence.length) {
            if (total < k) {
                right++;
                if (right < sequence.length) total += sequence[right];
            } else if (total > k) {
                total -= sequence[left]; 
                left++;
            } else {
                answers.add(new int[]{left, right});
                total -= sequence[left]; 
                left++;
                right++; 
                if (right < sequence.length) total += sequence[right];
            }
        }

        return answers.stream()
                .min(Comparator.comparingInt(a -> a[1] - a[0])) 
                .orElse(new int[]{});
    }
}