class Solution {
    public int solution(int n) {
        StringBuilder ternary = new StringBuilder();
        while (n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }
        ternary.reverse();

        int answer = 0;
        int power = 1;
        for (int i = 0; i < ternary.length(); i++) {
            answer += (ternary.charAt(i) - '0') * power;
            power *= 3;
        }

        return answer;
    }
}