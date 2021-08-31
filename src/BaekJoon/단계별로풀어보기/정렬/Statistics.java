package BaekJoon.단계별로풀어보기.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
5
1
3
8
-2
2
 */
public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.valueOf(br.readLine()));
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hm.put(arrayList.get(i), hm.getOrDefault(arrayList.get(i), 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });


        int valueA = (entryList.get(0).getKey() + entryList.get(entryList.size() - 1).getKey()) / 2;

        int valueB = entryList.get(entryList.size() / 2).getKey();

        int valueD = entryList.get(0).getKey() - entryList.get(entryList.size() - 1).getKey();

        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int valueC;
        if (entryList.size() == 1 || (entryList.get(0).getValue() == entryList.get(1).getValue()))
            valueC = entryList.get(entryList.size()-1).getKey();
        else
            valueC = entryList.get(0).getKey();

        System.out.println(valueA);
        System.out.println(valueB);
        System.out.println(valueC);
        System.out.println(valueD);
    }
}
