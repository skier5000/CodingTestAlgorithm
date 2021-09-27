package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj7562 {

    static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int node[][]; // 그래프 배열
    static int check[][]; // 방문 배열
    static String[] StringValueStart;
    static String[] StringValueEnd;
    static ArrayList<Integer> result = new ArrayList<>();
    static int matrixSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            matrixSize = Integer.parseInt(br.readLine());
            node = new int[matrixSize][matrixSize];
            check = new int[matrixSize][matrixSize];

            StringValueStart = br.readLine().split(" ");
            StringValueEnd = br.readLine().split(" ");

            int[] startNode = new int[]{Integer.parseInt(StringValueStart[0]), Integer.parseInt(StringValueStart[1])};
            int[] endNode = new int[]{Integer.parseInt(StringValueEnd[0]), Integer.parseInt(StringValueEnd[1])};

            bfs(startNode[0], startNode[1], endNode[0], endNode[1]);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    // BFS 메소드
    public static void bfs (int startNodeX, int startNodeY, int endNodeX, int endNodeY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startNodeX, startNodeY});
        check[startNodeX][startNodeY] = 1;

        Loop1 :
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            Loop2 :
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < matrixSize && ny < matrixSize) {
                    if (node[nx][ny] == 0 && check[nx][ny] < 1) {
                        queue.add(new int[]{nx, ny});
                        check[nx][ny] = check[x][y] + 1;
                    }
                }

                if (check[endNodeX][endNodeY] != 0) {
                    result.add(check[endNodeX][endNodeY] - 1);
                    break Loop1;
                }
            }
        }
    }

}
