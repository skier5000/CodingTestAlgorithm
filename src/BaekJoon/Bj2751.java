package BaekJoon;

import java.util.*;

/*
5
5
4
3
2
1
*/

public class Bj2751 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            arrList.add(scanner.nextInt());
        }

        Collections.sort(arrList);
//        for (int integer : arrList) {
//            System.out.println(integer);
//        }

        for(int value : arrList) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);

    }
}
