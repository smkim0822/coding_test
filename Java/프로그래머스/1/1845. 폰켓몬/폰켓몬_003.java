import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 1. Set으로 nums 중복 제거
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        
        // 2. N/2와 set.size() 중 최솟값 반환
        return Math.min(nums.length / 2, set.size());
    }
}