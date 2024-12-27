import java.util.*;

class Solution {
    public int solution(String dirs) {
        char[] chars;
        int answer = 0;
        Set<List<Integer>> set = new HashSet<>();
        chars = dirs.toCharArray();

        int[] currentIndex = {0, 0};
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'U':
                    if (currentIndex[1] >= 5) continue;
                    if (!set.contains((Arrays.asList(currentIndex[0], currentIndex[1] + 1, (int) 'D')))
                            && !set.contains((Arrays.asList(currentIndex[0], currentIndex[1], (int) 'U')))) {
                        set.add(new ArrayList<>(Arrays.asList(currentIndex[0], currentIndex[1], (int) 'U')));
                        answer++;
                    }
                    currentIndex[1] = currentIndex[1] + 1;
                    break;
                case 'D':
                    if (currentIndex[1] <= -5) continue;
                    if (!set.contains((Arrays.asList(currentIndex[0], currentIndex[1] - 1, (int) 'U')))
                            && !set.contains((Arrays.asList(currentIndex[0], currentIndex[1], (int) 'D')))) {
                        set.add(new ArrayList<>(Arrays.asList(currentIndex[0], currentIndex[1], (int) 'D')));
                        answer++;
                    }
                    currentIndex[1] = currentIndex[1] - 1;
                    break;
                case 'L':
                    if (currentIndex[0] <= -5) continue;
                    if (!set.contains((Arrays.asList(currentIndex[0] - 1, currentIndex[1], (int) 'R')))
                            && !set.contains((Arrays.asList(currentIndex[0], currentIndex[1], (int) 'L')))) {
                        set.add(new ArrayList<>(Arrays.asList(currentIndex[0], currentIndex[1], (int) 'L')));
                        answer++;
                    }
                    currentIndex[0] = currentIndex[0] - 1;
                    break;
                case 'R':
                    if(currentIndex[0] >= 5) continue;
                    if (!set.contains((Arrays.asList(currentIndex[0] + 1, currentIndex[1], (int) 'L')))
                            && !set.contains((Arrays.asList(currentIndex[0], currentIndex[1], (int) 'R')))) {
                        set.add(new ArrayList<>(Arrays.asList(currentIndex[0], currentIndex[1], (int) 'R')));
                        answer++;
                    }
                    currentIndex[0] = currentIndex[0] + 1;
                    break;
                default:
                    break;
            }
        }
        return answer;
    }
}