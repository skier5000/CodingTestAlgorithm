package BaekJoon.단계별로풀어보기.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arrayList.add(Integer.valueOf(s[i]));
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Integer compareX = arrayList.get(i); // 비교대상
            ArrayList<Integer> compareArr = new ArrayList<>();
            int cnt = 0;

            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(j) > compareX) {
                    cnt++;
                    compareArr.add(arrayList.get(j));
                } else if (j == arrayList.size() && arrayList.get(j) <= compareX && cnt == 0){
                    resultList.add(-1);
                } else if (j == arrayList.size()-1 && cnt == 0) {
                    resultList.add(-1);
                }
            }

            if (compareArr.size() != 0) {
                resultList.add(compareArr.get(0));
            }

            if (i + 1 == arrayList.size()) {
                resultList.add(-1);
            }
        }

        System.out.println(Arrays.toString(resultList.toArray()));

    }


}
