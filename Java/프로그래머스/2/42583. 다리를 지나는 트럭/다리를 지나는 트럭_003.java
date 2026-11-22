import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // 1. 무게와 건널 시간을 저장하는 Truck 객체 선언
    private static class Truck {
        int weight;
        int exitTime;
        
        Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Truck> bridge = new ArrayDeque<>();
        
        int currentWeight = 0;
        int time = 0;
        int idx = 0;
        
        while (idx < truck_weights.length) {
            time++;
            
            // 2. 다리 위 트럭이 건널 시간이라면 건너기
            if (!bridge.isEmpty() && bridge.peek().exitTime == time) {
                currentWeight -= bridge.poll().weight;
            }
            
            // 3. 트럭이 다리에 진입할 수 있으면 진입하기
            if (currentWeight + truck_weights[idx] <= weight) {
                currentWeight += truck_weights[idx];
                
                bridge.offer(new Truck(truck_weights[idx], time + bridge_length));
                
                idx++;
            }
            
            // 4. 트럭이 다리에 진입할 수 없다면 시간 넘기기
            else {
                time = bridge.peek().exitTime - 1;
            }
        }
        
        return bridge.peekLast().exitTime;
    }
}