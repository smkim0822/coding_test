import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    // 1. 노래 정보를 담는 전용 클래스
    private static class Song {
        int id;
        int plays;
        
        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 2. 두 가지 HashMap으로 역할 분리하기
        Map<String, Integer> genreTotalPlay = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotalPlay.put(genre, genreTotalPlay.getOrDefault(genre, 0) + play);
            songsByGenre.computeIfAbsent(genre, k -> new ArrayList()).add(new Song(i, play));
        }
        
        // 3. 두 단계 정렬 수행하기
        // 3-1. 장르 순서 정렬 (총 재생 내림차순)
        List<String> sortedGenres = new ArrayList<>(genreTotalPlay.keySet());
        sortedGenres.sort((a, b) -> Integer.compare(genreTotalPlay.get(b), genreTotalPlay.get(a)));
        
        // 3-2. 장르 내 노래 정렬 (재생 수 내림차순, 고유 번호 오름차순)
        // 4. 최대 2곡 추출
        List<Integer> result = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Song> songs = songsByGenre.get(genre);
            
            songs.sort((a, b) -> {
                if (a.plays != b.plays) {
                    return Integer.compare(b.plays, a.plays);
                }
                return Integer.compare(a.id, b.id);
            });
            
            int limit = Math.min(2, songs.size());
            
            for (int i = 0; i < limit; i++) {
                result.add(songs.get(i).id);
            }
        }
        
        // 5. List<Intger> -> int[] 변환
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}