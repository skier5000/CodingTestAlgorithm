package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이분그래프 {

    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nmValue = br.readLine();




    }

    public static void dfs(int N, int M, int depth) {

        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < N; i++) {

            // 만약 해당 노드(값)을 방문하지 않았다면?
            if (visit[i] == false) {

                visit[i] = true;		// 해당 노드를 방문상태로 변경
                arr[depth] = i + 1;		// 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(N, M, depth + 1);	// 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
        return;
    }
}
