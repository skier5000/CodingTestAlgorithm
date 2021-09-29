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

    private static ArrayList<ArrayList<Integer>> list;
    private static boolean [] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        checked = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1, 0);

        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (checked[i]) count++;
        }

        System.out.println(count-1);
    }

    private static void dfs(int index, int depth) {
        if (depth == 2) {
            return;
        }

        for (Integer i: list.get(index)) {
            checked[i] = true;
            dfs(i, depth + 1);
        }
    }
}
