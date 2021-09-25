package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
반례
2 2
-1 -1
-1 -1

2 2
0 0
0 0
 */
public class Boj7576 {
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int node[][]; // 그래프 배열
    static int check[][]; // 방문 배열
    static String[] StringValue;
    static int[] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringValue = br.readLine().split(" ");

        node = new int[Integer.parseInt(StringValue[1])][Integer.parseInt(StringValue[0])];
        check = new int[Integer.parseInt(StringValue[1])][Integer.parseInt(StringValue[0])];

        // 노드 구성
        for (int i = 0; i < Integer.parseInt(StringValue[1]); i++) {
            String[] chars = br.readLine().split(" ");
            for (int j = 0; j < Integer.parseInt(StringValue[0]); j++) {
                node[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }


        bfs();

        int returnValue = -1;

        Loop1 :
        for (int i = 0; i < check.length; i++) {
            Loop2 :
            for (int j = 0; j < check[i].length; j++) {

                if (check[i][j] == 0 && node[i][j] == 0) {
                    break Loop1;
                }

                if (returnValue < check[i][j]) {
                    returnValue = check[i][j];
                }
            }
        }

        if (returnValue != -1) {
            System.out.println(returnValue - 1);
        } else {
            System.out.println(-1);
        }

    }


    // BFS 메소드
    public static void bfs () {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < node.length; i++) {
            for (int j = 0; j < node[i].length; j++) {
                if (node[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    check[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < Integer.parseInt(StringValue[1]) && ny < Integer.parseInt(StringValue[0])) {
                    if (node[nx][ny] == 0 && check[nx][ny] < 1) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                    }
                }
            }
        }
    }
}
