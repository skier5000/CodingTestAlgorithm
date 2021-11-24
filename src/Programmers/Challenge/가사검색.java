package Programmers.Challenge;

import java.util.ArrayList;

public class 가사검색 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        가사검색 dd = new 가사검색();
        dd.solution(words, queries);
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int cnt = 0;
        ArrayList<String> wordsArrayList = new ArrayList<>();


        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            wordsArrayList.clear();

            for (int p = 0; p < words.length; p++) {
                wordsArrayList.add(words[p]);
            }

            Loop2:
            for (int j = 0; j < query.length(); j++) {

                if (query.charAt(j) == '?') {
                    for (int k = 0; k < words.length; k++) {
                        StringBuilder sb = new StringBuilder();

                        for (int l = 0; l < wordsArrayList.get(k).length(); l++) {
                            if (l == j)
                                sb.append("?");
                            if (l != j)
                                sb.append(wordsArrayList.get(k).charAt(l));
                        }


                        wordsArrayList.set(k, sb.toString());
                        sb.delete(0, sb.length());
                    }
                }
            }


            for (int j = 0; j < wordsArrayList.size(); j++) {
                if (query.equals(wordsArrayList.get(j)))
                    cnt++;
            }

            answer[i] = cnt;
            cnt = 0;

        }

//        for (int i : answer) {
//            System.out.println("i = " + i);
//        }

        return answer;
    }
}
