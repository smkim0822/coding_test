class Solution {
    public int solution(int a, int b, int c) {
        // 합 경우의 수 정의
        int sum1 = a + b + c;
        int sum2 = a * a + b * b + c * c;
        int sum3 = a * a * a + b * b * b + c * c * c;
        
        // 계단식 분기
        if (a == b && b == c) {
            return sum1 * sum2 * sum3;
        } else if ((a == b) || (b == c) || (c == a)) {
            return sum1 * sum2;
        } else {
            return sum1;
        }
    }
}