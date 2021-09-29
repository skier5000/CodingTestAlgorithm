package BaekJoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
자신의 친구 + 친구의 친구
6
7
1 2
1 3
3 4
2 3
4 5
 */
public class Boj5567 {

    public static int arr[][];		// 친구 관계
    public static boolean visit[];	// 방문 여부
    public static int n;	// 동기 수
    public static int m;	// 리스트 길이
    public static int count = 0;	// 초대할 친구 수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        arr = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;	// 친구 관계 표시
        }

        for(int i=2; i<=n; i++) {
            if(arr[1][i] == 1) {	 // 상근이와 친구인 경우
                if(!visit[i]) {		 // 상근이와 친구인데 아직 방문하지 않은 경우
                    count ++;		 // 초대
                    visit[i] = true; // 방문 표시
                }

                // 상근이 친구의 친구 찾기 - 상근이와 연결된 정점에 연결되어 있는 정점 찾기.
                for(int j=2; j<=n; j++) {
                    if(arr[i][j] == 1 && !visit[j]) {
                        count ++;			// 상근이 친구의 친구도 초대
                        visit[j] = true;	// 방문 표시
                    }
                }
            }
        }

        System.out.println(count);
        bf.close();
    }
}
