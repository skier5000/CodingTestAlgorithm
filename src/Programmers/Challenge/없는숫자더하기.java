package Programmers.Challenge;

import java.util.ArrayList;
import java.util.Arrays;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{1, 2, 3, 4, 6, 7, 8, 0};
        int[] numbers2 = new int[]{5, 8, 4, 0, 6, 7, 9};

        없는숫자더하기 dd = new 없는숫자더하기();
        dd.solution(numbers1);
        dd.solution(numbers2);
    }

    public int solution(int[] numbers) {
        int[] arr = new int[9];
        int answer = -1;
        int idx = 0;

        Arrays.sort(numbers);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        return answer;
    }
}
