class Solution {
    public int solution(int a, int b) {
        String num1 = String.valueOf(a);
        String num2 = String.valueOf(b);
        
        int ab = Integer.parseInt(num1 + num2);
        
        return Math.max(ab, 2 * a * b);
    }
}