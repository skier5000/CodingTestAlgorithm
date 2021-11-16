package Programmers.SkillCheckTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Level1Solution2 {
    public static void main(String[] args) {
        Level1Solution2 dd = new Level1Solution2();
        System.out.println(dd.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));  // 14
        System.out.println(dd.solution(new int[]{5, 8, 4, 0, 6, 7, 9}));  // 6
    }

    public int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> map = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            map.add(i);
        }

        for (int number : numbers) {

            for (int i = 0; i < 10; i++) {
                if (map.size() < i) {
                    break;
                }

                if (map.get(i) == number) {
                    map.remove(i);
                    break;
                }

            }

        }

        for (int i = 0; i < map.size(); i++) {
            answer += map.get(i);
        }

        return answer;
    }
}
