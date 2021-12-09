package BaekJoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
4 9 2
3 0 7
8 1 6

0 12 12
16 10 0
8 8 14

495 468 0
0 522 414
441 0 549
 */
public class 매직스퀘어 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int matrix[][] = new int[3][3];; // 그래프 배열
    static int check[][] = new int[3][3];; // 그래프 배열
    static int nx = 0;
    static int ny = 0;
    static int giJunNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // matrix 구성
        for (int i = 0; i < 3; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(0, 0);


    }

    // BFS 메소드
    public static void bfs (int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        check[a][b] = 1;

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length) {
                    if (matrix[nx][ny] != 0 && check[nx][ny] < 1) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                    }
                }
            }
        }
    }

}
