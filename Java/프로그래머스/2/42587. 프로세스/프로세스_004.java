import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 우선 순위를 큐에 저장한다.
        Deque<Integer> processes = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int priority : priorities) {
            processes.offer(priority);
            pq.offer(priority);
        }
        
        
        int count = 0;
        
        while (!processes.isEmpty()) {
            int process = processes.poll();
            
            // 2. 큐.poll()보다 큰 원소가 있다면 (우선순위 큐 활용) offer
            if (process < pq.peek()) {
                processes.offer(process);
                
                location = (location == 0) ? processes.size() - 1 : location - 1;
            }
            
            // 3. 없다면 실행, count++;
            else {
                count++;
                pq.poll();
                
                if (location == 0) {
                    return count;
                }
                
                location = location - 1;
            }
        }
        
        return 0;
    }
}