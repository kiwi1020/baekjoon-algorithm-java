import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queueProgress = new LinkedList<>();
        Queue<Integer> queueSpeeds = new LinkedList<>();
        List<Integer> days = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i: progresses) queueProgress.add(i);
        for (int i: speeds) queueSpeeds.add(i);

        while (!queueProgress.isEmpty() && !queueSpeeds.isEmpty()) {
            int currentProcess = queueProgress.poll();
            int currentSpeed = queueSpeeds.poll();
            int currentDay = (100 - currentProcess) % currentSpeed == 0 ?  (100 - currentProcess) / currentSpeed : (100 - currentProcess) / currentSpeed + 1;
            days.add(currentDay);
        }

        System.out.println(days);

        int currentDay = days.get(0);
        int processNum = 0;

        for (int i = 0; i < days.size(); i++) {

            if (currentDay < days.get(i)) {
                answer.add(processNum);
                processNum = 1;
                currentDay = days.get(i);
            } else {
                processNum++;
            }

            if (i == days.size() - 1)
                answer.add(processNum);
        }

        return answer;
    }
}