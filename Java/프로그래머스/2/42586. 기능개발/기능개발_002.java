import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 작업에 필요한 일수를 days 큐에 저장
        Deque<Integer> days = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = ((100 - progresses[i]) + speeds[i] - 1) / speeds[i];
            days.offer(day);
        }
        
        // 2. days를 peek하며 count 누적 -> answerList에 저장
        List<Integer> answerList = new ArrayList<>();

        while (!days.isEmpty()) {
            int count = 1;
            int currentDeployDay = days.poll();
            
            while (!days.isEmpty() && days.peek() <= currentDeployDay) {
                days.poll();
                count++;
            }
            
            answerList.add(count);
        }
        
        // 3. answerList를 int[]형으로 반환
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}