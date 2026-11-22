import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        // 1. 인덱스를 저장할 스택을 선언한다.
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            // 2. 가격이 떨어지면 가격이 떨어진 요소들을 pop하고 answer 배열에 저장한다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            
            // 3. 인덱스를 스택에 푸시한다.
            stack.push(i);
        }
        
        // 4. 가격이 떨어지지 않은 요소들을 answer 배열에 저장한다.
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}