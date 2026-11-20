class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean result = switch (ineq + eq) {
                case ">=" -> n >= m;
                case "<=" -> n <= m;
                case ">!" -> n > m;
                case "<!" -> n < m;
                default -> false;
        };
        
        return result ? 1 : 0;
    }
}