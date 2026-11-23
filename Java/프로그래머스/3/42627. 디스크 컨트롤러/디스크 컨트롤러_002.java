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
            // 2. 요청 시각이 되면 최소힙에 삽입한다. (작업 소요시간 오름차순)
            while (jobIndex < jobs.length && currentTime >= jobs[jobIndex][0]) {
                waitingQueue.offer(jobs[jobIndex]);
                jobIndex++;
            }

            // 3. 힙이 비어있으면 시간을 넘긴다.
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
        
        return totalWaitTime / jobs.length;
    }
}