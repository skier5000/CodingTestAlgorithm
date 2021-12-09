package CodingTest.BeforeTest;

import java.util.*;

public class SSG2021_02BeforeTest_Solution_01 {

    public static void main(String[] args) {
        SSG2021_02BeforeTest_Solution_01 dd = new SSG2021_02BeforeTest_Solution_01();

        dd.solution(new int[][]{{1, 4}, {3, 4}, {3, 10}});
        dd.solution(new int[][]{{1, 1}, {2, 2}, {1, 2}});
    }

    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        int cnt = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < v.length; i++) {
            hm.put(v[i][0], hm.getOrDefault(v[i][0], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> elem : hm.entrySet()) {
            if (elem.getValue() == 1) {
                answer[0] = elem.getKey();
                break;
            }
        }

        hm.clear();

        for (int i = 0; i < v.length; i++) {
            hm.put(v[i][1], hm.getOrDefault(v[i][1], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> elem : hm.entrySet()) {
            if (elem.getValue() == 1) {
                answer[1] = elem.getKey();
                break;
            }
        }


        return answer;
    }

}
