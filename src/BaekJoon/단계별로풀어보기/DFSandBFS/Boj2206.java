package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
-> 갈 수 있는 방향(0)이 있으면 이동
->
반례

8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100
> 29


3 6
010000
010111
000110
>12

5 5
00000
11110
00000
01111
00010
>9

5 4
0001
1101
0001
0111
0010
>12

10 10
0111011011
1010011011
1000100011
1000101100
0011010000
1101110101
0110111101
1010100100
1111001011
0001010100
>-1

2 4
0110
0010
>5
 */
public class Boj2206 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int node[][]; // 그래프 배열
    static int check[][]; // 방문 배열
    static String[] StringValue;
    static int[] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringValue = br.readLine().split(" ");

        node = new int[Integer.parseInt(StringValue[0])][Integer.parseInt(StringValue[1])];
        check = new int[Integer.parseInt(StringValue[0])][Integer.parseInt(StringValue[1])];

        // 노드 구성
        for (int i = 0; i < Integer.parseInt(StringValue[0]); i++) {
            String[] chars = br.readLine().split("");
            for (int j = 0; j < Integer.parseInt(StringValue[1]); j++) {
                node[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        bfs(0, 0);

        if (check[Integer.parseInt(StringValue[0])-1][Integer.parseInt(StringValue[1])-1] < 1) { // 끝까지 방문하지 않았으면
            System.out.println(-1);
        } else {
            System.out.println(check[Integer.parseInt(StringValue[0])-1][Integer.parseInt(StringValue[1])-1]);
        }

    }

    // BFS 메소드
    public static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{a, b});
        check[a][b] = 1;

        int cnt = 0;
        // 노드의 재구성 (벽 부수기)
        if (Integer.parseInt(StringValue[0]) < Integer.parseInt(StringValue[1])) { // 세로로 더 길 때
            for (int i = 0; i < node[0].length; i++) {
                if (node[0][i] == 1) {
                    if (i+1 < Integer.parseInt(StringValue[1])) {
                        if (node[0][i + 1] == 0) {
                            node[0][i] = 0; // 벽부수기
                            cnt++;
                            break;
                        }
                    }
                }
            }

            if (cnt == 0) {
                for (int i = 0; i < node.length; i++) {
                    if (node[i][0] == 1) {
                        if (i+1 < Integer.parseInt(StringValue[0])) {
                            if (node[i + 1][0] == 0) {
                                node[i][0] = 0;
                                cnt++;
                                break;
                            }
                        }
                    }
                }
            }
        } else { // 가로로 더 길 때
            for (int i = 0; i < node.length; i++) {
                if (node[i][0] == 1) {
                    if (i+1 < Integer.parseInt(StringValue[0])) {
                        break;
                    }
                    if (node[i + 1][0] == 0) {
                        node[i][0] = 0; // 벽부수기
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt == 0) {
                for (int i = 0; i < node[0].length; i++) {
                    if (node[0][i] == 1) {
                        if (i + 1 < Integer.parseInt(StringValue[1])) {
                            break;
                        }
                        if (node[0][i + 1] == 0) {
                            node[0][i] = 0; // 벽부수기
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < Integer.parseInt(StringValue[0]) && ny < Integer.parseInt(StringValue[1])) {
                    if (node[nx][ny] == 0 && check[nx][ny] < 1) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                    }
                }
            }
        }
    }

}
