package CodingTest.CjNo1TechWin;

import java.util.ArrayList;
import java.util.Arrays;

/*
DFS 문제
 */
public class Question2 {

    public static void main(String[] args) {
        Question2 question2 = new Question2();

        //question2.solution(new String[]{"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"}, 1, 9);
        //question2.solution(new String[]{"1 2 3 4 5 6 7 8 9 10","2 8", "3 17 19 12 13 9 14 15 10", "20 2 21"}, 1, 10);
        question2.solution(new String[]{"0 1 2 3 4","1 12 13 14"}, 2, 12);
    }

    public int solution(String[] subway, int start, int end) {
        int answer = 0;

        boolean[] vistied = new boolean[subway.length];

        // 그림예시 그래프의 연결상태를 2차원 배열로 표현
        // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
//        public void dfs(int nodeIndex) {
//            // 방문 처리
//            vistied[nodeIndex] = true;
//            // 방문 노드 출력
//            System.out.print(nodeIndex + " -> ");
//            // 방문한 노드에 인접한 노드 찾기
//            for (int node : graph[nodeIndex]) {
//                // 인접한 노드가 방문한 적이 없다면 DFS 수행
//                if(!vistied[node]) {
//                    dfs(node);
//                }
//            }
//        }

        String startToString = String.valueOf(start);
        String endToString = String.valueOf(end);

        for (int i = 0; i < subway.length; i++) {
            for (int j = 0; j < subway[i].length(); j++) {

            }
        }


        return answer;
    }
}
