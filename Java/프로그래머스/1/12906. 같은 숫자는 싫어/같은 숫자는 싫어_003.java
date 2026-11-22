import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        // 1. arr를 순회하며 answerList의 마지막 원소와 같지 않으면 answerList에 더한다.
        List<Integer> answerList = new ArrayList<>();

        answerList.add(arr[0]);     // 첫번째 원소 삽입
        
        for (int i = 1; i < arr.length; i++) {
            if (answerList.get(answerList.size() - 1) != arr[i]) {
                answerList.add(arr[i]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}