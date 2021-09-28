package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj1707 {

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

            //bfs(startNode[0], startNode[1], endNode[0], endNode[1]);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
