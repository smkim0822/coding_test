import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        // 1. 스택 선언
        Deque<Character> dq = new ArrayDeque<>();
        
        // 2. s를 순회하며 '('이면 push, ')'이면 pop. isEmpty()면 return false
        for (char c : s.toCharArray()) {
            if (c == '(') {
                dq.push(c);
            } else {
                if (dq.isEmpty()) {
                    return false;
                }
                
                if (dq.peek() != '(') {
                    return false;
                }
                
                dq.pop();
            }
        }
        
        return dq.isEmpty();
    }
}