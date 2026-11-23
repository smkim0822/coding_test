import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 최소힙 활용
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : scoville) {
            pq.offer(num);
        }
        
        int count = 0;
        
        // 1. 힙의 최솟값이 K보다 작을 동안 작업 반복한다.
        while (pq.size() >= 2 && pq.peek() < K) {
            // 2. 최솟값 + (두번째 최솟값 * 2)를 삽입한다.
            int first = pq.poll();
            int second = pq.poll();

            int newFood = first + second * 2;
            pq.offer(newFood);
            
            count++;
        }
        
        // 3. 리턴
        return (pq.peek() < K) ? -1 : count;
    }
}