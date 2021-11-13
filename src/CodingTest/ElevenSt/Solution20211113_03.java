package CodingTest.ElevenSt;

import java.util.Arrays;
import java.util.Collections;

public class Solution20211113_03 {
    public static void main(String[] args) {
        Solution20211113_03 dd = new Solution20211113_03();

        System.out.println(dd.solution(123));
        System.out.println(dd.solution(553));

    }

    public int solution(int N) {
        StringBuilder sb = new StringBuilder();
        char[] chars = String.valueOf(N).toCharArray();
        Integer[] arr = new Integer[chars.length];

        for (int i = 0; i < chars.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].toString());
        }

        return Integer.parseInt(String.valueOf(sb));

    }
}
