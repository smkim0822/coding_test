import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        // 1. 중복 제거를 위한 Set 생성 (HashSet 활용)
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        // 2. 가질 수 있는 폰켓몬 수는 전체의 절반
        int maxSelect = nums.length / 2;
        
        // 3. 중복을 제거한 종류의 수와 절반 중 더 작은 값을 리턴
        return Math.min(maxSelect, set.size());
    }
}