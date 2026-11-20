class Solution {
    public String solution(String code) {
        int len = code.length();
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            char ch = code.charAt(i);
            
            if (ch == '1') {
                mode = 1 - mode;
            } else if (i % 2 == mode) {
                sb.append(ch);
            }
        }
        
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}