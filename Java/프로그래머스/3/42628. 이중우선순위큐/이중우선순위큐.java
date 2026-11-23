import java.util.PriorityQueue;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        // 1. 최소힙과 최대힙을 선언한다.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // 2. 연산을 처리한다.
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            char command = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());
            
            if (command == 'I') {
                minHeap.offer(number);
                maxHeap.offer(number);
            } else if (command == 'D' && !minHeap.isEmpty()) {
                if (number == 1) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        // 3. 큐 상태에 따라 반환한다.
        return (minHeap.isEmpty()) ? new int[]{0, 0} : new int[]{maxHeap.peek(), minHeap.peek()};
    }
}