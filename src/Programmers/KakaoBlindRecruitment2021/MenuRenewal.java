package Programmers.KakaoBlindRecruitment2021;

import java.util.*;


/**
 * 참고 URL
 * https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B7%9C-%EC%95%84%EC%9D%B4%EB%94%94-%EC%B6%94%EC%B2%9C-java-2021-KAKAO-BLIND-RECRUITMENT
 */
public class MenuRenewal {
    private static List<String> combination;

    public static void main(String[] args) {
        MenuRenewal menuRenewal = new MenuRenewal();
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] orders3 = {"XYZ", "XWY", "WXA"};

        int[] course1 = {2, 3, 4};
        int[] course2 = {2, 3, 5};
        int[] course3 = {2, 3, 4};

        String[] result1 = {"AC", "ACDE", "BCFG", "CDE"};
        String[] result2 = {"ACD", "AD", "ADE", "CD", "XYZ"};
        String[] result3 = {"WX", "XY"};

        System.out.println(menuRenewal.solution(orders1, course1));
    }


    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        // 타 메소드에서도 사용하기 위해 static 변수로
        combination = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {   // 한 주문당 모든 조합 구하기
            char[] orders_char = orders[i].toCharArray();
            Arrays.sort(orders_char);

            for (int index = 0; index < orders_char.length - 1; index++) {  // 차례대로 한글자씩 선택 후
                for (int j = 0; j < course.length; j++) {   // course 에 있는 모든 경우
                    dfs(orders_char, index, 1, course[j], String.valueOf(orders_char[index]));
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String key : combination) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max_value = 0;

            for (String key : keySetList) {
                if (map.get(key) >= 2 && key.length() == course[i]) {
                    if (map.get(key) >= max_value) {
                        ansList.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        Collections.sort(ansList);
        answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;
    }

    public static void dfs(char[] arr, int idx, int length, int course, String str) {
        if (length == course) {    // 경우의 수 추가
            combination.add(str);
        }

        for (int i = idx + 1; i < arr.length; i++) {
            dfs(arr, i, length + 1, course, str + arr[i]);
        }
    }

}
