import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int currentTime = 0;
        int totalWaitTime = 0;
        int completedJobs = 0;
        int jobIndex = 0;
        
        while (completedJobs < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }
            
            if (pq.isEmpty()) {
                currentTime = jobs[jobIndex][0];
            }
            
            else {
                int[] job = pq.poll();
                currentTime += job[1];
                totalWaitTime += currentTime - job[0];
                completedJobs++;
            }
        }
        
        return totalWaitTime / jobs.length;
    }
}