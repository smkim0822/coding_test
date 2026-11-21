import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 1. <의상 종류, 종류별 개수> Map 저장
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 2. 종류별 개수 + 1을 곱하고 1을 빼서 리턴
        int answer = 1;
        
        for (int count : map.values()) {
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}