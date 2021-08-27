package BaekJoon.단계별로풀어보기.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
3
21 Junkyu
21 Dohyun
20 Sunyoung

 */
public class SortByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N;
        N = Integer.parseInt(st.nextToken());

        ArrayList<SortAll> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            arrayList.add(new SortAll(Integer.parseInt(s[0]), s[1], i));
        }

        Collections.sort(arrayList, new Comparator<SortAll>() {
            @Override
            public int compare(SortAll o1, SortAll o2) {
                return o1.age - o2.age;
            }
        });


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).age + " " + arrayList.get(i).name + "\n");
        }
    }

    static class SortAll {
        int age;
        String name;
        int idx;

        public SortAll(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }
}
