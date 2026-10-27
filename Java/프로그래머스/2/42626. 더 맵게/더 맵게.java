import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int mixCount = 0;
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + second * 2;
            
            pq.offer(newScoville);
            mixCount++;
        }
        
        return mixCount;
    }
}