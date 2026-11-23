import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        // 1. jobs 배열을 요청 시각 오름차순으로 정렬한다.
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> waitingQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            
            return Integer.compare(a[0], b[0]);
        });

        int currentTime = 0;
        int totalWaitTime = 0;
        int jobIndex = 0;
        int completedCount = 0;
        
        while (completedCount < jobs.length) {
            // 2. 요청 시각이 지난 작업을 힙에 삽입한다. (소요시간 오름차순 정렬)
            while (jobIndex < jobs.length && currentTime >= jobs[jobIndex][0]) {
                waitingQueue.offer(jobs[jobIndex]);
                jobIndex++;
            }
            
            // 3. 힙이 비어있다면 다음 작업 요청 시각으로 점프한다.
            if (waitingQueue.isEmpty()) {
                currentTime = jobs[jobIndex][0];
            }
            
            // 4. 힙이 비어있지 않다면 작업을 수행한다.
            else {
                int[] completedJob = waitingQueue.poll();
                currentTime += completedJob[1];
                totalWaitTime += currentTime - completedJob[0];
                completedCount++;
            }
        }
        
        return totalWaitTime / completedCount;
    }
}