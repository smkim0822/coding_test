class Solution {
    public int solution(int[] num_list) {
        // num_list 배열을 순회하며 원소 홀짝 판별하고 oddNum, evenNum 뒤에 이어붙이기
        int oddNum = 0;
        int evenNum = 0;
        
        for (int num : num_list) {
            if (num % 2 != 0) {
                oddNum = oddNum * 10 + num;
            } else {
                evenNum = evenNum * 10 + num;
            }
        }
        
        // 합 반환
        return oddNum + evenNum;
    }
}