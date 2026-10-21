import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int pastIndex = stack.poll();
                answer[pastIndex] = i - pastIndex;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int pastIndex = stack.poll();
            answer[pastIndex] = prices.length - 1 - pastIndex;
        }
        
        return answer;
    }
}