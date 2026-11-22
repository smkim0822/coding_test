import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 작업이 끝나기까지 남은 일수를 days 큐에 저장한다.
        Deque<Integer> days = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            days.offer(((100 - progresses[i]) + speeds[i] - 1 ) / speeds[i]);
        }
        
        // 2. days 큐 앞에서부터 함께 배포할 수 있는 기능 수를 answer 배열에 저장한다.
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
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}