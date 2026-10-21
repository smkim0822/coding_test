import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int currentWeight = 0;
        
        for (int truck : truck_weights) {
            while (true) {
                if (bridge.size() == bridge_length) {
                    currentWeight -= bridge.poll();
                }

                if ((currentWeight + truck) <= weight) {
                    bridge.offer(truck);
                    currentWeight += truck;
                    time++;
                    break;
                }
                
                else {
                    bridge.offer(0);
                    time++;
                }
            }
        }
        
        return time + bridge_length;
    }
}