package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
10
5
2
3
1
4
2
3
5
1
7
 */
/* 카운팅 정렬 */
public class Bj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 범위 (0 ~ 10000) 사실상 0은 제외
        int[] cnt = new int[10001];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine())] ++;  // 해당 인덱스의 값을 1 증가
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        // 0은 입력범위에서 없으므로 1부터 시작
        for(int i = 1; i < 10001; i++){
            // i 값이 개수가 0 이 될 때 까지 출력 (빈도수를 의미)
            while(cnt[i] > 0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}