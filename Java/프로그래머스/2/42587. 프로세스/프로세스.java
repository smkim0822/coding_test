import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigherPriorities = false;
            
            for (int[] doc : queue) {
                if (doc[1] > current[1]) {
                    hasHigherPriorities = true;
                    break;
                }
            }
            
            if (hasHigherPriorities) {
                queue.offer(current);
            } else {
                answer++;
                
                if (current[0] == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
}