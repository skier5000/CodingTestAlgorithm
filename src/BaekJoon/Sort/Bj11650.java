package BaekJoon.Sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*

문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

5
3 4
1 1
1 -1
2 2
3 3
 */
public class Bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        //System.out.println("matrix = " + matrix);

        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (int[] ints : matrix) {
//            bw.write(ints[0] + " " + ints[1] + "\n");
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1]);
        }

        /*
        -- matrix
            0 = {int[2]@812} [3, 4]
            1 = {int[2]@813} [1, 1]
            2 = {int[2]@814} [1, -1]
            3 = {int[2]@815} [2, 2]
            4 = {int[2]@816} [3, 3]
        -- 1
            o1 [1,1]
            o2 [3,4]

        -- 2
            o1 [1,-1]
            o2 [1,1]
        -- 3

        -- 4

        -- 5

         */

    }
}
