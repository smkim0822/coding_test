class Solution {
    public int solution(int a, int b) {
        String num1 = String.valueOf(a);
        String num2 = String.valueOf(b);
        
        int ab = Integer.parseInt(num1 + num2);
        int ba = Integer.parseInt(num2 + num1);
        
        return ab >= ba ? ab : ba;
    }
}