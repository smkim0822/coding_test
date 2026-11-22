import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        // 1. 인덱스를 저장할 스택 선언한다.
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            // 2. 가격이 떨어지면 while문으로 떨어진 주식을 answer 배열에 저장한다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int pastIdx = stack.pop();
                answer[pastIdx] = i - pastIdx;
            }
            
            // 3. 가격 인덱스를 스택에 푸시한다.
            stack.push(i);
        }

        // 4. 가격이 떨어지지 않은 요소들을 인덱스를 활용해 answer 배열에 저장한다.
        while (!stack.isEmpty()) {
            int pastIdx = stack.pop();
            answer[pastIdx] = prices.length - pastIdx - 1;
        }
        
        
        return answer;
    }
}