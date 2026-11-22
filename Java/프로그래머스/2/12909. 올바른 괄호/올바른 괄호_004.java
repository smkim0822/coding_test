import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        // 1. 스택 선언
        Deque<Character> stack = new ArrayDeque<>();
        
        stack.push(s.charAt(0));    // 첫번째 원소 예외처리
        
        // 2. '('이면 스택에 저장, ')'이면 if (stack.pop() !=  '(') {return false;}
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        
        // 3. return
        return stack.isEmpty();
    }
}