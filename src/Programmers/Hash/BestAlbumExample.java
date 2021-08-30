package Programmers.Hash;

import java.util.*;

public class BestAlbumExample {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        //return {4,1,3,0}

        BestAlbumExample bestAlbum = new BestAlbumExample();

        bestAlbum.solution(genres, plays);
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int count = 0;
        ArrayList<Integer> resultArray = new ArrayList<>();

        HashMap<String, Integer> albumPlaysRank = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            albumPlaysRank.put(genres[i], albumPlaysRank.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(albumPlaysRank.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        ArrayList<idxAlbum> idxAlbumArrayList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            idxAlbumArrayList.add(new idxAlbum(i, genres[i], plays[i]));
        }
        Collections.sort(idxAlbumArrayList, new Comparator<idxAlbum>() {
            @Override
            public int compare(idxAlbum o1, idxAlbum o2) {
                return o2.play - o1.play;
            }
        });

        // 각 두개씩 가져오기 -> 한 곡짜리 일 경우 테스트케이스에서 에러
        for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
            for (int i = 0; i < idxAlbumArrayList.size(); i++) {
                if (count == 2) {
                    count = 0;
                    break;
                }
                if (stringIntegerEntry.getKey().equals(idxAlbumArrayList.get(i).genre)){
                    resultArray.add(idxAlbumArrayList.get(i).idx);
                    count++;
                }
            }
        }

        answer = resultArray.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    static class idxAlbum {
        int idx;
        String genre;
        int play;

        public idxAlbum(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }
    }
}