import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 1. Set으로 중복 제거
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        // 2. N/2와 set.size() 중 작은 값 리턴
        return Math.min(set.size(), nums.length / 2);
    }
}