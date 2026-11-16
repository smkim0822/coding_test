class Solution {
    public int solution(String s) {
        if (s.length() == 1)return 1;
        
        int minLength = s.length();
        
        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder compressed = new StringBuilder();
            
            String prev = s.substring(0, step);
            int count = 1;
            
            for (int j = step; j <= s.length(); j += step) {
                int endIdx = Math.min(j + step, s.length());
                String curr = s.substring(j, endIdx);
                
                if (prev.equals(curr)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    
                    prev = curr;
                    count = 1;
                }
            }
            
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);
            
            minLength = Math.min(minLength, compressed.length());   
        }
        
        return minLength;
    }
}