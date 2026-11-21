import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        int i = 0;
        while (i < arr.length) {
            if (list.size() == 0 || list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
                i++;
            } else {
                list.remove(list.size() - 1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}