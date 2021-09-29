package BaekJoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj5427 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static String node[][]; // 그래프 배열
    static int check[][]; // 방문 배열
    static int[] startSangGuen;
    static int[] startFire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            // 노드구성
            String[] M = br.readLine().split(" ");
            node = new String[Integer.parseInt(M[1])][Integer.parseInt(M[0])];
            check = new int[Integer.parseInt(M[1])][Integer.parseInt(M[0])];
            for (int j = 0; j < Integer.parseInt(M[1]); j++) {
                String[] chars = br.readLine().split("");
                for (int k = 0; k < chars.length; k++) {
                    node[j][k] = chars[k];
                    if (node[j][k].equals("@")) { // 상근이 시작위치
                        startSangGuen = new int[]{j, k};
                    }
                    if (node[j][k].equals("*")) { // 불 시작위치
                        startFire = new int[]{j, k};
                    }
                }
            }

            // bfs
            bfs(startSangGuen[0], startSangGuen[1], startFire[0], startFire[1], M);


        }

    }

    // BFS 메소드
    public static void bfs (int startSangGuenX, int startSangGuenY, int startFireX, int startFireY, String[] M) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startSangGuenX, startSangGuenY});
        check[startSangGuenX][startSangGuenY] = 1;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < Integer.parseInt(M[1]) && ny < Integer.parseInt(M[0])) {
                    if (node[nx][ny].equals(".") && check[nx][ny] < 1) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                    }
                }
            }
        }
    }
}
