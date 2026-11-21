import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 1. Map에 <의상 종류, 개수>를 저장
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 2. 종류별 개수를 곱하고 -1 리턴
        int answer = 1;
        
        for (int count : map.values()) {
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}