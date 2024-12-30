import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int n = nums.length / 2;
        
        for (int i : nums) set.add(i);
        
        if (n < set.size()) return n;
        
        return set.size();
    }
}