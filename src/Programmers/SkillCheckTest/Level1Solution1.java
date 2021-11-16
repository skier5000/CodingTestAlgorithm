package Programmers.SkillCheckTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Level1Solution1 {
    public static void main(String[] args) {
/*
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 */

        Level1Solution1 dd = new Level1Solution1();
        dd.solution(118372); // 873211

    }

    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();

        String s = Long.toString(n);
        for (int i = 0; i < s.length(); i++) {
            arrayList.add(Character.getNumericValue(s.charAt(i)));
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
        }

        return Long.parseLong(sb.toString());
    }
}
