package BaekJoon.단계별로풀어보기.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

 */
public class Boj1932 {

    static int[][] arr;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];

        // map 만들기
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 가장 마지막 행의 값들을 DP의 마지막 행에도 똑같이 복사
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(find(0, 0));

    }


    static int find(int depth, int idx) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        if(depth == N - 1)
            return dp[depth][idx];

        // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
        if (dp[depth][idx] == null) {
            dp[depth][idx] =
                    Math.max(find(depth + 1, idx), find(depth + 1, idx + 1))
                    + arr[depth][idx];
        }
        return dp[depth][idx];

    }

}
