class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0, 0, numbers, target);
        return answer;
    }
    
    public int dfs(int index, int num, int[] numbers, int target) {
        if (index == numbers.length)
            return num == target ? 1 : 0;

        int add = dfs(index + 1, num + numbers[index] , numbers, target);
        int sub = dfs(index + 1, num - numbers[index] , numbers, target);
        return add + sub;
    }
}