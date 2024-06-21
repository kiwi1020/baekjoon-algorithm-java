import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
    
        Set<Integer> set = new HashSet<>();

        int n = nums.length / 2;

        for (int num : nums) {
            set.add(num);
        }
        
        return Math.min(n, set.size());
    }
}