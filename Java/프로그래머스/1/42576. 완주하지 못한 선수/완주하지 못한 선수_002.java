import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 1. 참여자 명단 작성
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. 완주자 명단 차감
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