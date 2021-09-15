package BaekJoon.단계별로풀어보기.큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 수가 주어진다. (1 ≤ xi ≤ 100)

전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.


4
D
0
[]

 */
public class Boj5430Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            char[] cmd = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            String[] strings = stringMethod(br.readLine());

            //int[] arr = new int[Integer.parseInt(br.readLine())];

            for (String num : strings) {
                deque.offer(Integer.valueOf(num));
            }


            for (char c : cmd) {

                switch (c) {
                    case 'R' :
                        ArrayDeque<Integer> arr = new ArrayDeque<>();
                        while (!deque.isEmpty()) {
                            arr.offer(deque.pollLast());
                        }
                        deque.clear();
                        deque = arr;
                        break;
                    case 'D' :
                        deque.pollFirst();
                        break;
                    default:
                        break;
                }
            }

            if (deque.size() == 0) {
                System.out.println("error");
            } else {
                System.out.println(deque);
            }

        }
    }

    public static String[] stringMethod (String string) {
        String substring = "";

        if (string.contains(",")) {

            if (string.length() == 2) {
                String[] returnArr = new String[0];
                return returnArr;
            } else {
                String[] returnArr = string.substring(1, string.length() - 1).split(",");
                return returnArr;
            }
        } else {
            if (string.length() == 2) {
                String[] retrunArr = new String[0];
                return retrunArr;
            } else {
                substring = string.substring(1, string.length() - 1);
                String[] returnArr = new String[1];
                returnArr[0] = substring;
                return returnArr;
            }
        }
    }
}
