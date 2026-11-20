class Solution {
    public int solution(int[] num_list) {
        // num_list 배열을 순회하며 모든 원소들의 곱 mul과 모든 원소들의 합 sum을 구한다.
        int mul = 1;    // 모든 원소들의 곱
        int sum = 0;    // 모든 원소들의 합
        
        for (int i = 0; i < num_list.length; i++) {
            mul *= num_list[i];
            sum += num_list[i];
        }
        
        // 모든 원소들의 합 sum을 이용해 모든 원소들의 합의 제곱 sumSquare을 구한다.
        int sumSquare = sum * sum;
        
        // mul과 sumSquare을 비교해 1 또는 0 출력
        return mul < sumSquare ? 1 : 0;
    }
}