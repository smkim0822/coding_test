class Solution {
    public String solution(int[] numLog) {
        int len = numLog.length;
        String result = "";
        
        for (int i = 1; i < len; i++) {
            int control = numLog[i] - numLog[i - 1];
            switch (control) {
                    case 1 -> result += 'w';
                    case -1 -> result += 's';
                    case 10 -> result += 'd';
                    case -10 -> result += 'a';
            }
        }
        
        return result;
    }
}