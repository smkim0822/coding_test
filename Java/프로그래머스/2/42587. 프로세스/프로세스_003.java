import java.util.Deque;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 실행 대기 큐와 우선순위 큐 선언
        Deque<Integer> dq = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int priority : priorities) {
            dq.offer(priority);
            pq.offer(priority);
        }
        
        int count = 0;
        int loc = location;
        
        // 2. 실행 대기 큐에서 poll보다 큰 원소가 있는지 탐색
        while (!dq.isEmpty()) {
            int process = dq.poll();

            // 3. 있으면 offer, loc = loc == 0 ? dq.size() - 1 : loc - 1
            if (process < pq.peek()) {
                dq.offer(process);
                
                loc = (loc == 0) ? dq.size() - 1 : loc - 1;
            }

            // 4. 없으면 count++, if loc == 0: return count, loc--
            else {
                pq.poll();
                count++;
                
                if (loc == 0) {
                    return count;
                }
                
                loc--;
            }
        }

        return -1;
    }
}