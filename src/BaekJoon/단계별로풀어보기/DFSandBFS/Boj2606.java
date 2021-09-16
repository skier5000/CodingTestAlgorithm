package BaekJoon.단계별로풀어보기.DFSandBFS;


/*

7      // 컴퓨터의 수
6      // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

7
6
1 2
2 3
1 5
5 2
5 6
4 7

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2606 {

    static int start; //시작정점
    static int node[][]; // 그래프 배열
    static boolean check[]; // 방문 배열

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 컴퓨터의 수
        int m = sc.nextInt(); // 네트워크 상에 연결되어 있는 컴퓨터 쌍의 수 즉, 간선의 수

        node = new int[n + 1][n + 1];
        check = new boolean[n+1];
        for (int i = 0; i < m; i++) { // 그래프 구성
            int a = sc.nextInt();
            int b = sc.nextInt();
            node[a][b] = 1;
            node[b][a] = 1;

        }

        bfs(1);
    }

    public static void bfs (int start) { // BFS 메소드
        Queue<Integer> queue = new LinkedList<>();

        check[start] = true;
        queue.offer(start);
        int cnt = 0; // 감염 된 컴퓨터의 수
        while(!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 1; i < node.length; i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가
                if (node[x][i] == 1 && check[i] != true) {
                    queue.offer(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt); //모든 탐색을 마치고 cnt 출력
    }
}
