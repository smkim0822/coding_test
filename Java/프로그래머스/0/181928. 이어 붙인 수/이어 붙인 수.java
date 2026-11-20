class Solution {
    public int solution(int[] num_list) {
        // num_list 배열을 순회하며 원소가 홀수이면 oddNum에 이어붙이고 원소가 짝수이면 evenNum에 이어붙인다.
        StringBuilder oddNumSb = new StringBuilder();
        StringBuilder evenNumSb = new StringBuilder();
        
        for (int num : num_list) {
            if (num % 2 != 0) {
                oddNumSb.append(num);
            } else {
                evenNumSb.append(num);
            }
        }
        
        // oddNum과 evenNum을 정수로 변환하여 더한다.
        int oddNum = Integer.parseInt(oddNumSb.toString());
        int evenNum = Integer.parseInt(evenNumSb.toString());
        
        // 합 리턴
        return oddNum + evenNum;
    }
}