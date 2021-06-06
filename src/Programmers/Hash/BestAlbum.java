package Programmers.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        //return {4,1,3,0}

        solution(genres, plays);
    }


    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {0};
        int i;
        int j;
        String[] bestSongs;
        ArrayList result1 = new ArrayList();
        ArrayList<Object> result2 = new ArrayList<>();

        System.out.println("genres : " + Arrays.toString(genres));
        System.out.println("plays : " + Arrays.toString(plays));
        System.out.println("------------------------------------------------------");
        HashMap<String, Integer> hm = new HashMap<>();


        // 장르별 노래 합산 재생횟수
        for(i=0;i<genres.length; i++) {
            hm.put(genres[i], plays[i]);
        }

        List<Object> keySetList = new ArrayList<>(hm.keySet());

        // {pop=2500, classic=800}
        Collections.sort(keySetList, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));

        for(j=0;j<keySetList.size();j++) {
            String mostSong = (String) keySetList.get(j);
            result1 = songValidation(mostSong, genres, plays);
            // mostSong 이면서 가장 재생 횟수가 많은거 앞으로
            System.out.println("mostSong 이면서 가장 재생 횟수가 많은 인덱스 뽑기 : " + result1);
        }

        return answer;
    }


    public static ArrayList<Object> songValidation(String songCategory, String[] genres, int[] plays) {
        ArrayList<Object> result = new ArrayList<>();

        System.out.println("songCategory : " + songCategory);

        for(int k=0; k<genres.length; k++) {
            if(genres[k] == songCategory) {
                result.add(plays[k]);
            }
        }


        return result;
    }





}











