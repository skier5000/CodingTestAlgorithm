package Programmers.Challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        게임맵최단거리 dd = new 게임맵최단거리();
        dd.solution(maps1);
        dd.solution(maps2);
    }

    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int node[][]; // 그래프 배열
    static int check[][]; // 방문 배열

    public int solution(int[][] maps) {
        int answer = 0;
        int bfsValue = 0;

        node = maps;
        check = new int[maps.length][maps[0].length];

        // 시작지점
        Loop1:
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 1) {
                    bfsValue = bfs(maps, i, j);
                    break Loop1;
                }
            }
        }

        // 길 없으면
        if (bfsValue == 0) {
            return -1;
        } else {
            return bfsValue;
        }

    }


    public static int bfs (int[][] maps, int a, int b) { // BFS 메소드
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        check[a][b] = 1;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
                    if (node[nx][ny] == 1 && check[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                    }

                    // 종료
                    if (check[check.length-1][check[0].length-1] != 0) {
                        queue.clear();
                        return check[check.length-1][check[0].length-1];
                    }
                }
            }
        }

        return 0;
    }
}
