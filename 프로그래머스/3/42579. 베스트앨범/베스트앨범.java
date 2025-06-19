import java.util.*;

class Solution {
    static class Music {
        int id;
        int plays;

        Music(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<Music>> genreToMusicList = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreTotalPlays.put(genres[i], genreTotalPlays.getOrDefault(genres[i], 0) + plays[i]);

            genreToMusicList.computeIfAbsent(genres[i], k -> new ArrayList<>())
                            .add(new Music(i, plays[i]));
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));

        List<Integer> answer = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Music> musics = genreToMusicList.get(genre);
            musics.sort((a, b) -> {
                if (b.plays == a.plays) return a.id - b.id;
                return b.plays - a.plays;
            });

            for (int i = 0; i < Math.min(2, musics.size()); i++) {
                answer.add(musics.get(i).id);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
