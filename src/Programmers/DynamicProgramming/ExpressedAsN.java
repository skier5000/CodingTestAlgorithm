package Programmers.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ExpressedAsN {
    public int solution(int N, int number) {
        int answer = -1;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0 ; i < 8; i++) {
            list.add(new HashSet<>());
        }
        list.get(0).add(N); // N을 1개만 사용할 경우, N 자신만 표현 가능

        for (int i = 0; i < 8; i++) {
            // 1. N을 (i + 1)번 이어붙인 경우
            list.get(i).add(Integer.parseInt(stringRepeat(N, i + 1)));

            // 2. 이전 단계의 결과를 서로 사칙연산한 결과
            // [N을 1개 사용한 경우] union [(i + 1) - 1개 사용한 경우]
            // [N을 2개 사용한 경우] union [(i + 1) - 2개 사용한 경우]
            // ...
            for (int j = 0; j < i; j++) {
                for (int case1 : list.get(j)) {
                    for (int case2 : list.get(i - 1 - j)) {
                        list.get(i).add(case1 + case2);
                        list.get(i).add(case1 - case2);
                        list.get(i).add(case1 * case2);

                        if (case2 != 0) {
                            list.get(i).add(case1 / case2);
                        }
                    }
                }
            }

            if (list.get(i).contains(number)) {
                answer = i * 1;
                break;
            }
        }

        return answer;
    }


    private String stringRepeat(int N, int times) {
        StringBuilder answer = new StringBuilder();
        String str = String.valueOf(N);
        answer.append(str.repeat(Math.max(0, times)));
        return answer.toString();
    }


}