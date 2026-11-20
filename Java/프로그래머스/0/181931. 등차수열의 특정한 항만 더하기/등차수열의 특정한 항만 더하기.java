class Solution {
    public int solution(int a, int d, boolean[] included) {
        // included 배열을 순회하며 true이면 result += a + i * d를 누적한다.
        int result = 0;
        
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                result += a + i * d;
            }
        }
        
        return result;
    }
}