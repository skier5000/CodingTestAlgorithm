package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2667 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int node[][]; // 그래프 배열
    static boolean check[][]; // 방문 배열
    static int[] aparts = new int[25*25];
    static int apartNum = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        node = new int[N][N];
        check = new boolean[N][N];

        // 노드 구성
        for (int i = 0; i < N; i++) { // 그래프 구성
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                node[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        // bfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (node[i][j] == 1 && !check[i][j]) {
                    apartNum++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for (int i = 0; i < aparts.length; i++) {
            if (aparts[i] == 0) {
            } else {
                System.out.println(aparts[i]);
            }
        }
    }

    public static void bfs (int a, int b) { // BFS 메소드
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        check[a][b] = true;
        aparts[apartNum]++;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (node[nx][ny] == 1 && !check[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                        aparts[apartNum]++;
                    }
                }
            }
        }
    }

}
