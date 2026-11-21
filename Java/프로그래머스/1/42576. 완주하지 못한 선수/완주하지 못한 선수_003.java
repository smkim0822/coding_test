import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. 참여자 명단을 HashMap에 저장
        Map<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. HashMap에서 완주자 차감
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 3. 낙오자 찾기
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        
        return "";
    }
}