public class Solution {
    public int solution(int N) {
        int batteryUsage = 0;
        while (N > 0) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N -= 1;
                batteryUsage += 1;
            }
        }
        return batteryUsage;
    }
}