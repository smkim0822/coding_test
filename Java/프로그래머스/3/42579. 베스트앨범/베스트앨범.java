import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    static class Song implements Comparable<Song> {
        int id;
        String genre;
        int plays;
        
        public Song(int id, String genre, int plays) {
            this.id = id;
            this.genre = genre;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Song other) {
            if (this.plays == other.plays) {
                return this.id - other.id;
            }

            return other.plays - this.plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlay = new HashMap<>();
        List<Song> songList = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            genreTotalPlay.put(genres[i], genreTotalPlay.getOrDefault(genres[i], 0) + plays[i]);
            songList.add(new Song(i, genres[i], plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(genreTotalPlay.keySet());
        sortedGenres.sort((g1, g2) -> genreTotalPlay.get(g2) - genreTotalPlay.get(g1));
        
        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songsInGenre = songList.stream()
                .filter(s -> s.genre.equals(genre))
                .sorted()
                .collect(Collectors.toList());
            
            for (int i = 0; i < Math.min(songsInGenre.size(), 2); i++) {
                bestAlbum.add(songsInGenre.get(i).id);
            }
        }
        
        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}