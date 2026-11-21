class Solution {
    public String solution(int[] numLog) {
        int len = numLog.length;
        StringBuilder sb = new StringBuilder(len - 1);
        
        for (int i = 1; i < len; i++) {
            char ch = switch(numLog[i] - numLog[i - 1]) {
                    case 1 -> 'w';
                    case -1 -> 's';
                    case 10 -> 'd';
                    case -10 -> 'a';
                    default -> ' ';
            };
            
            sb.append(ch);
        }
        
        return sb.toString();
    }
}