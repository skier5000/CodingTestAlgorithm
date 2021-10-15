package Programmers.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand1 = "right";
        String hand2 = "left";
        String hand3 = "right";

        String answer1 = "LRLLLRLLRRL";
        String answer2 = "LRLLRRLLLRR";
        String answer3 = "LLRLLRLLRL";

        키패드누르기 dd = new 키패드누르기();
        dd.solution(numbers1, hand1);
        dd.solution(numbers2, hand2);
        dd.solution(numbers3, hand3);
    }

    /*

    1, 4, 7을 입력할 때는 왼손 엄지손가락 사용

    3, 6, 9를 입력할 때는 오른손 엄지손가락 사용

    2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용
    만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용

     */
    public String solution(int[] numbers, String hand) {
        HashMap<String, String> handPosition = new HashMap<>();
        handPosition.put("left", "*");
        handPosition.put("right", "#");

        int[] leftSide = new int[]{1, 4, 7};
        int[] rightSide = new int[]{3, 6, 9};
        int[] middleSide = new int[]{2, 5, 8, 0};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {

            int gotoNumber = numbers[i];

            /* 왼손사용 */
            if (Arrays.stream(leftSide).anyMatch(value -> value == gotoNumber)) {
                handPosition.put("left", String.valueOf(gotoNumber));
                sb.append("L");
                continue;
            }

            /* 오른손사용 */
            if (Arrays.stream(rightSide).anyMatch(value -> value == gotoNumber)) {
                handPosition.put("right", String.valueOf(gotoNumber));
                sb.append("R");
                continue;
            }

            /* 가까운 손가락 사용 */
            if (Arrays.stream(middleSide).anyMatch(value -> value == gotoNumber)) {
                continue;
            }

        }

        return "answer";
    }

}
