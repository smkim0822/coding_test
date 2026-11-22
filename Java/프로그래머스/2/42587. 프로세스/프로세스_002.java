import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. priorities를 순회하며 poll보다 큰 원소가 있는지 탐색
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int priority : priorities) {
            dq.offer(priority);
        }
        
        int count = 0;
        int loc = location;
        
        while (!dq.isEmpty()) {
            int process = dq.poll();

            // 2. 있으면 offer, loc-- (if loc == 0, loc= dq.size() - 1)
            if (hasBigger(dq, process)) {
                dq.offer(process);
                
                if (loc == 0) {
                    loc = dq.size() - 1;
                } else {
                    loc--;
                }
            }
            // 3. 없으면 count++. (if loc == 0, return count), loc--
            else {
                count++;
                
                if (loc == 0) {
                    return count;
                }
                
                loc--;
            }
        }
        
        return -1;
    }
    
    private boolean hasBigger(Deque<Integer> dq, int process) {
        for (int num : dq) {
            if (num > process) {
                return true;
            }
        }
        
        return false;
    }
}