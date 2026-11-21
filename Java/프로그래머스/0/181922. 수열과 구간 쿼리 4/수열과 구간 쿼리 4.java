class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        // 쿼리 순회
        for (int idx = 0; idx < queries.length; idx++) {
            // s, e, k를 입력받는다.
            int s = queries[idx][0];
            int e = queries[idx][1];
            int k = queries[idx][2];
            
            // [s, e] 순회하며 배수 판별 로직
            for (int i = s; i <= e; i++) {
                if (i % k == 0) {
                    arr[i] += 1;
                }
            }          
        }
        
        return arr;
    }
}