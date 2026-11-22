import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
                
        for (int i = 0; i < prices.length; i++) {
            // 1. 가격이 떨어지면 가격이 떨어진 주식이 가격이 떨어지지 않은 기간을 answer 배열에 저장한다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            
            // 2. 스택에 주식 인덱스를 삽입한다.
            stack.push(i);
        }
        
        // 3. 가격이 떨어지지 않은 주식들이 가격이 떨어지지 않은 기간을 answer 배열에 저장한다.
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}