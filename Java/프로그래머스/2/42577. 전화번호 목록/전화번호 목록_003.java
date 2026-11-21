import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. Set에 전화번호 저장
        Set<String> set = new HashSet<>();
        
        for (String phone_number : phone_book) {
            set.add(phone_number);
        }
        
        // 2. 각 번호의 1글자부터 length - 1 글자까지의 부분 문자열이 Set에 있는지 확인
        for (String phone_number : phone_book) {
            for (int i = 1; i < phone_number.length(); i++) {
                if (set.contains(phone_number.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}