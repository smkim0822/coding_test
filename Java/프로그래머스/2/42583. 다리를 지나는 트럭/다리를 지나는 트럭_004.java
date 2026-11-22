import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private static class Truck {
        int weight;
        int exitTime;
        
        Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 다리를 큐로 선언
        Deque<Truck> bridge = new ArrayDeque<>();
        
        int currentWeight = 0;
        int time = 0;
        int idx = 0;
        
        while(idx < truck_weights.length) {
            time++;
        
            // 2. 트럭이 다리를 다 건너면 제거
            if (!bridge.isEmpty() && time == bridge.peek().exitTime) {
                currentWeight -= bridge.poll().weight;
            }

            // 3. 트럭이 진입할 수 있으면 진입
            if (currentWeight + truck_weights[idx] <= weight) {
                currentWeight += truck_weights[idx];

                bridge.offer(new Truck(truck_weights[idx], time + bridge_length));

                idx++;
            }

            // 4. 트럭이 진입할 수 없으면 시간 점프
            else {
                time = bridge.peek().exitTime - 1;
            }
        }
        
        return bridge.peekLast().exitTime;
    }
}