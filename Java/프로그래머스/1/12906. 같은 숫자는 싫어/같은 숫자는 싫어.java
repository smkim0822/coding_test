import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        int preNum = -1;
        
        for (int num : arr) {
            if (preNum != num) {
                list.add(num);
                preNum = num;
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}