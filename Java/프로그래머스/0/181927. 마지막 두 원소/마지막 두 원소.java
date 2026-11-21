class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] result = new int[len + 1];
        
        for (int i = 0; i < len; i++) {
            result[i] = num_list[i];
        }
        
        // 마지막 원소가 그전 원소보다 큰 경우: 마지막 원소에서 그전 원소를 뺀 값을 추가
        if (num_list[len - 1] > num_list[len - 2]) {
            result[len] = num_list[len - 1] - num_list[len - 2];
        }
        
        // 마지막 원소가 그전 원소보다 크지 않은 경우: 마지막 원소를 두 배한 값을 추가
        else {
            result[len] = num_list[len - 1] * 2;
        }
        
        // 반환
        return result;
    }
}