import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = Arrays.copyOf(num_list, len + 1);
        
        int last = num_list[len - 1];
        int prev = num_list[len - 2];
        
        answer[len] = last > prev ? last - prev : last * 2;
        
        return answer;
    }
}