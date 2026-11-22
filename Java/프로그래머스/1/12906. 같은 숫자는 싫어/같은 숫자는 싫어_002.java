import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] solution(int []arr) {
        // 큐 선언
        Deque<Integer> dq = new ArrayDeque<>();
        
        // 1. 큐 마지막 원소와 다르면 큐에 넣기
        dq.offer(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (dq.peekLast() != arr[i]) {
                dq.offer(arr[i]);
            }
        }
        
        // 2. 반환
        int[] answer = new int[dq.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dq.poll();
        }
        
        return answer;
    }
}