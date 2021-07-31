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
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, playListIndex> answerHm = new HashMap<>();

        // 정답 해시맵 생성 및 정렬
        for (int i = 0; i < genres.length; i++) {
            answerHm.put(genres[i], new playListIndex(plays[i], i));
        }

        // 장르별 노래 재생빈도수
        for (int i = 0; i < genres.length; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }

        // hm -> classic : 1,450회, pop : 3,100회    =>   정렬 (내림차순)
        Iterator iteratorHm = sortByValue(hm).iterator();
        while(iteratorHm.hasNext()) {
            String temp = (String) iteratorHm.next(); // pop

        }

        return answer;
    }

    // 해시맵 정렬
    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }

        });
//        Collections.reverse(list); // 주석시 오름차순
        return list;
    }

    class playListIndex {
        int plays;
        int index;

        public playListIndex(int plays, int index) {
            this.plays = plays;
            this.index = index;
        }
    }

}
