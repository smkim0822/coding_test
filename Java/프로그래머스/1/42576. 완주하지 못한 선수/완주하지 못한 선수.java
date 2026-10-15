import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
     
        // 1. 참가자 명단 등록 (인원, 인원수)
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. 완주자 명단 차감
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 3. 값이 0이 아닌(완주하지 못한) 단 한 명 찾기
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        
        return "";
    }
}