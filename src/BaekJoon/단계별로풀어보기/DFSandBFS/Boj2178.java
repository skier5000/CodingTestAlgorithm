package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2178 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int node[][]; // 그래프 배열
    static int check[][]; // 방문 배열
    static String[] StringValue;
    static int nx = 0;
    static int ny = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringValue = br.readLine().split(" ");

        node = new int[Integer.parseInt(StringValue[0])][Integer.parseInt(StringValue[1])];
        check = new int[Integer.parseInt(StringValue[0])][Integer.parseInt(StringValue[1])];

        // 노드 구성
        for (int i = 0; i < Integer.parseInt(StringValue[0]); i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < Integer.parseInt(StringValue[1]); j++) {
                node[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }


        // bfs
        bfs(0, 0);

        System.out.println(check[node.length - 1][node[node.length - 1].length - 1]);

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

                if (nx >= 0 && ny >= 0 && nx < Integer.parseInt(StringValue[0]) && ny < Integer.parseInt(StringValue[1])) {
                    if (node[nx][ny] == 1 && check[nx][ny] < 1) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                    }
                }
            }
        }
    }

}
