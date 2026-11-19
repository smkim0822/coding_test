class Solution {
    public String solution(String str1, String str2) {
        int len = str1.length();
        char[] result = new char[len * 2];
        
        for (int i = 0; i < len; i++) {
            result[i * 2] = str1.charAt(i);
            result[i * 2 + 1] = str2.charAt(i);
        }
        
        return new String(result);
    }
}