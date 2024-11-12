class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0L;
            long prevTime = 0L;

            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                long timeCur = times[i];

                if (diff <= mid) {
                    sum += timeCur;
                } else {
                    int fails = diff - mid;
                    sum += (timeCur + prevTime) * fails + timeCur;
                }

                prevTime = timeCur;
            }

            if (sum <= limit) {
                answer = mid;  
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer <= 0 ? 1 : answer;
    }
}