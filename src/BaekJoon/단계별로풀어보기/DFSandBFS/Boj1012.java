package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1012 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int node[][]; // 그래프 배열
    static boolean check[][]; // 방문 배열
    static int N;
    static String[] StringValue;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 총 노드 수
        for (int i = 0; i < N; i++) { // 그래프 구성
            cnt = 0;
            StringValue = br.readLine().split(" ");   // 10 8 17
            node = new int[Integer.parseInt(StringValue[0])][Integer.parseInt(StringValue[1])];
            check = new boolean[Integer.parseInt(StringValue[0])][Integer.parseInt(StringValue[1])];

            // 노드 구성
            for (int j = 0; j < Integer.parseInt(StringValue[2]); j++) {
                String[] s = br.readLine().split(" ");
                node[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
            }


            // bfs
            for (int k = 0; k < node.length; k++) {
                for (int j = 0; j < node[k].length; j++) {
                    if (node[k][j] == 1 && !check[k][j]) {
                        bfs(k, j);
                    }
                }
            }

            System.out.println(cnt);
        }


    }

    // BFS 메소드
    public static void bfs (int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        check[a][b] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < Integer.parseInt(StringValue[0]) && ny < Integer.parseInt(StringValue[1])) {
                    if (node[nx][ny] == 1 && !check[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                    }
                }
            }
        }

        cnt++;
    }
}
