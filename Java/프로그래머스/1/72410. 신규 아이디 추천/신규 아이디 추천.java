class Solution {
    public String solution(String new_id) {
        String recommend_id = new_id.toLowerCase();
        
        recommend_id = recommend_id.replaceAll("[^a-z0-9-_.]", "");
        
        recommend_id = recommend_id.replaceAll("\\.{2,}", ".");
        
        recommend_id = recommend_id.replaceAll("^[.]|[.]$", "");
        
        if (recommend_id.isEmpty()) {
            recommend_id = "a";
        }
        
        if (recommend_id.length() >= 16) {
            recommend_id = recommend_id.substring(0, 15);
            recommend_id = recommend_id.replaceAll("[.]$", "");
        }
        
        StringBuilder sb = new StringBuilder(recommend_id);
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}