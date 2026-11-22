import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 다리를 길이가 bridge_length인 큐로 표현한다.
        Deque<Integer> bridge = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        // 2. 무게를 변수로 관리한다.
        int currentWeight = 0;
        int time = 0;
        int idx = 0;
        
        // 3. 트럭 진입 여부에 따라 트럭 무게나 0을 큐에 삽입한다.
        while (idx < truck_weights.length) {
            currentWeight -= bridge.poll();
            
            if (currentWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }

            time++;            
        }
        
        // 4. 마지막 트럭이 다리를 건너는 시간을 더한다.
        time += bridge_length;
        
        return time;
    }
}