import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. phone_book 오름차순 정렬
        Arrays.sort(phone_book);
        
        // 2. phone_book[i]가 startsWith(phone_book[i - 1])인지 확인
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }
        
        return true;
    }
}