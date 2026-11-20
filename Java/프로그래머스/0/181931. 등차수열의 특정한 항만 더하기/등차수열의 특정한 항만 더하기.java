class Solution {
    public int solution(int a, int d, boolean[] included) {
        // included 배열을 순회하며 (true인 원소의 개수)와, (true인 원소의 인덱스)의 합을 구한다.
        // (true인 원소의 개수) * a + (true인 원소의 인덱스) * d를 return
        int count = 0;
        int idxSum = 0;
        
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                count++;
                idxSum += i;
            }
        }
        
        return count * a + idxSum * d;
    }
}