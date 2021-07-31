package Programmers.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NetworkArraySolution {

    private static final int CONNECTED = 1;

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        // return 2;
        // return 1;

        solution(n1, computers1);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i=0 ; i<n ; i++) {
            if (visited[i]){
                continue;
            }

            // queue 에 i 번째 값 삽입
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            while (!queue.isEmpty()) {
                // queue 에서 꺼내서 current 변수에 삽입
                int current = queue.poll();
                visited[current] = true;

                for (int j=0 ; j<n ; j++){
                    if (!(current == j) && computers[current][j] == CONNECTED && !visited[j]){
                        queue.offer(j);
                    }
                }
            }
            answer++;
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}