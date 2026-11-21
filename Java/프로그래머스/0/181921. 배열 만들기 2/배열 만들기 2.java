import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        int start = l % 5 == 0 ? l : l + (5 - l % 5);
        
        for (int i = start; i <= r; i += 5) {
            if (isZeroOrFive(i)) {
                list.add(i);
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private boolean isZeroOrFive(int num) {
        while (num > 0) {
            int digit = num % 10;

            if (digit != 0 && digit != 5) {
                return false;
            }
            
            num /= 10;
        }
        
        return true;
    }
}