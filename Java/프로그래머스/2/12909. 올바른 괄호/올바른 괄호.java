import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        if (s.charAt(0) == ')') {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}