import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
            .collect(Collectors.groupingBy(c -> c[1], Collectors.counting()))
            .values()
            .stream()
            .reduce(1L, (x, y) -> x * (y + 1))
            .intValue() - 1;
    }
}