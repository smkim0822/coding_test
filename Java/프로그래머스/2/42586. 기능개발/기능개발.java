import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int currentDeployDay = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= currentDeployDay) {
                queue.poll();
                count++;
            }
            
            answerList.add(count);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}