package BaekJoon.단계별로풀어보기.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1012 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int node[][]; // 그래프 배열
    static boolean check[][]; // 방문 배열
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}
