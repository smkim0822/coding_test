class Solution {
    public int solution(int n, String control) {
        for (char ch : control.toCharArray()) {
            switch (ch) {
                    case 'w' -> n += 1;
                    case 's' -> n -= 1;
                    case 'd' -> n += 10;
                    case 'a' -> n -= 10;
            };
        }
        
        return n;
    }
}